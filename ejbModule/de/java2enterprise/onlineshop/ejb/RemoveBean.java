package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Item;

@Stateless
public class RemoveBean implements RemoveBeanLocal {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
    private EntityManager em;

    @Override
    public String removeItem(Item item) {
    	if (!em.contains(item)) {
    		item = em.merge(item);
    	}
        em.remove(item);
        return "item deleted";
    }
}

