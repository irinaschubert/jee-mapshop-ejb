package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;
import de.java2enterprise.onlineshop.model.Status;

@Stateless
public class SellBean implements SellBeanLocal {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager em;

    @Override
    public String persist(Item item) {
        em.persist(item);
        return "item persisted";
    }
    
    @Override
    public Customer findCustomer(Long id) {
    	Customer customer = em.find(Customer.class, id);
    	return customer;
    }
    
    @Override
    public Item findItem(Long id) {
    	Item item = em.find(Item.class, id);
    	return item;
    }
    
    @Override
    public Status findStatus(Long id) {
    	Status status = em.find(Status.class, id);
    	return status;
    }
}

