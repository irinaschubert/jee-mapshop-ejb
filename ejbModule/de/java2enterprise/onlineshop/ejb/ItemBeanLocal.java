package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Item;

@Local
public interface ItemBeanLocal extends Serializable {
    
    String persistItem(Item item);
    
    Item findItem(Long id);
    
    String removeItem(Item item);
    
    String editItem(Item item);
}
