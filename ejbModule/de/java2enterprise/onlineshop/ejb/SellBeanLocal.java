package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;

@Local
public interface SellBeanLocal extends Serializable {
    String persist(Item item);
    
    Customer find(Long id);
}
