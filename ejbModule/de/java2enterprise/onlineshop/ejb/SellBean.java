package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;

@Stateless
public class SellBean implements SellBeanLocal {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
    private EntityManager em;

    @Override
    public String persist(Item item) {
        em.persist(item);
        System.out.println("item persisted");
        return "item persisted";
    }
    
    @Override
    public Customer find(Long id) {
    	Customer customer = em.find(Customer.class, id);
    	return customer;
    }
}

