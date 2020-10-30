package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Item;

@Local
public interface RemoveBeanLocal extends Serializable {
    String removeItem(Item item);
    
    String deactivateItem(Item item);
}
