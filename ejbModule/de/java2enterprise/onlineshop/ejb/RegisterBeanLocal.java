package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Customer;

@Local
public interface RegisterBeanLocal extends Serializable {
    String persist(Customer customer);
    
    String removeCustomer(Customer customer);
}
