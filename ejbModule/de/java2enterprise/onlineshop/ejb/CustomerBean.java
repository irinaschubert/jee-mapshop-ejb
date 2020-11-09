package de.java2enterprise.onlineshop.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.java2enterprise.onlineshop.model.Customer;

@Stateless
public class CustomerBean implements CustomerBeanLocal {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager em;
	
    @Override
    public String persistCustomer(Customer customer) {
        em.persist(customer);
        return "customerPersisted";
    }
    
    @Override
    public String removeCustomer(Customer customer) {
    	if (!em.contains(customer)) {
    		customer = em.merge(customer);
    	}
        em.remove(customer);
        
        FacesMessage m = new FacesMessage(
            "Succesfully deleted account!",
            "User account was successfully deleted.");
        FacesContext
            .getCurrentInstance()
            .addMessage("welcomeForm", m);
        return "customerRemoved";
    }
    
    @Override
    public String editCustomer(Customer customer) {
    	try {
            em.merge(customer);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        return "customer edited";
    }

	@Override
    public Customer findCustomer(Long id) {
    	Customer customer = em.find(Customer.class, id);
    	return customer;
    }
	
	@Override
    public List<Customer> findCustomerByCredentials(String email, String password) {
		TypedQuery<Customer> query = em.createQuery(
        		"FROM " + Customer.class.getSimpleName() + " c "
                        + "WHERE c.email= :email "
                        + "AND c.password= :password",
                Customer.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getResultList();
    }
}

