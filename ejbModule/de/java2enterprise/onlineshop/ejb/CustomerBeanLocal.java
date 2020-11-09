package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Customer;

@Local
public interface CustomerBeanLocal extends Serializable {
	
	String persistCustomer(Customer customer);
    
    String removeCustomer(Customer customer);
	
    String editCustomer(Customer customer);

    Customer findCustomer(Long id);
	
	List<Customer> findCustomerByCredentials(String email, String password);
}