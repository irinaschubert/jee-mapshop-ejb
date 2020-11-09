package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Item;

@Stateless
public class ItemBean implements ItemBeanLocal {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager em;
    
	@Override
    public String persistItem(Item item) {
        em.persist(item);
        return "item persisted";
    }
    
    @Override
    public Item findItem(Long id) {
    	Item item = em.find(Item.class, id);
    	return item;
    }
	
    @Override
    public String removeItem(Item item) {
    	System.out.println("item to remove: " + item.getTitle());
    	try {
    		if (!em.contains(item)) {
    			item = em.merge(item);
    		}
    		em.remove(item);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        return "item removed";
    }
    
    @Override
    public String editItem(Item item) {
    	System.out.println("item to edit: " + item.getTitle());
    	try {
            em.merge(item);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        return "item edited";
    }
    
    
}

