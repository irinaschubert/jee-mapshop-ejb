package de.java2enterprise.onlineshop.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class CustomerBean implements CustomerBeanLocal {

	private static final long serialVersionUID = 1L;
    
    private final static Logger log = Logger.getLogger(CustomerBean.class.toString());
	
	@PersistenceContext
    private EntityManager em;
	
    @Override
    public String persistCustomer(Customer customer) {
    	try {
    		em.persist(customer);
    	}catch(Exception e) {
    		log.severe(e.getMessage());
    	}
        return "customerPersisted";
    }
    
    @Override
    public String removeCustomer(Customer customer) {
    	try {
    		if (!em.contains(customer)) {
    			customer = em.merge(customer);
	    	}
	        em.remove(customer);
    	}catch(Exception e) {
    		log.severe(e.getMessage());
    	}
    	
        return "customerRemoved";
    }
    
    @Override
    public String editCustomer(Customer customer) {
    	try {
            em.merge(customer);
    	}catch(Exception e) {
    		log.severe(e.getMessage());
    	}
        return "customerEdited";
    }

	@Override
    public Customer findCustomer(Long id) {
		try {
			Customer customer = em.find(Customer.class, id);
			return customer;
		}catch(Exception e) {
			log.severe(e.getMessage());
		}
    	return null;    	
    }
	
	@Override
    public List<Customer> findCustomerByCredentials(String email, String password) {
		try{
			TypedQuery<Customer> query = em.createQuery(
        		"FROM " + Customer.class.getSimpleName() + " c "
                        + "WHERE c.email= :email "
                        + "AND c.password= :password",
                Customer.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getResultList();
		}catch(Exception e) {
			log.severe(e.getMessage());
		}
		return new ArrayList<Customer>();
    }
}

