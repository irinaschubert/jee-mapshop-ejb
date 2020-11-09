package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Customer;

@Local
public interface CustomerBeanLocal extends Serializable {
	
	Customer findCustomer(Long id);
    
	String persistCustomer(Customer customer);
    
    String removeCustomer(Customer customer);
}
