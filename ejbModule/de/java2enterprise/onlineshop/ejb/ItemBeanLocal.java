package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;
import de.java2enterprise.onlineshop.model.Status;

@Local
public interface ItemBeanLocal extends Serializable {
    
    Long persistItem(Item item);
    
    String removeItem(Item item);
    
    String editItem(Item item);
    
    Item findItem(Long id);
    
    List<Item> findAll();
    
    List<Item> findChildItems(Long productId);
    
    List<Item> findItemsByQuery(Status status, String queryTerm);
    
    List<Item> findItemsByStatus(Status status);
    
    List<Item> findItemsByStatusAndBuyer(Status status, Customer buyer);
    
    List<Item> findItemsByStatusAndSeller(Status status, Customer seller);
    
    List<Item> findItemsByTwoStatusesAndSeller(Status status1, Status status2, Customer seller);
    
    List<Item> findItemsByThreeStatusesAndSeller(Status status1, Status status2, Status status3, Customer seller);
}
