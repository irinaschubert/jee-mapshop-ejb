package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class RegisterBean implements RegisterBeanLocal {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
    private EntityManager em;

    @Override
    public String persist(Customer customer) {
        em.persist(customer);
        return "customer persisted";
    }
}

