package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
        return "customerPersisted";
    }
    
    @Override
    public String removeCustomer(Customer customer) {
    	System.out.println("Customer to remove: " + customer.getEmail());
    	if (!em.contains(customer)) {
    		customer = em.merge(customer);
    	}
        em.remove(customer);
        
        FacesMessage m = new FacesMessage(
            "Succesfully deleted account!",
            "User account was successfully deleted including the active items belonging to it.");
        FacesContext
            .getCurrentInstance()
            .addMessage("welcomeForm", m);
        
        return "customerRemoved";
    }
}

