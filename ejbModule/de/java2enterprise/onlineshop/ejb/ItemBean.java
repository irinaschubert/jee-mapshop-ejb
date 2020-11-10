package de.java2enterprise.onlineshop.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;
import de.java2enterprise.onlineshop.model.Status;

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
    public String removeItem(Item item) {
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
    	try {
            em.merge(item);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        return "item edited";
    }
    
    @Override
    public Item findItem(Long id) {
    	Item item = em.find(Item.class, id);
    	return item;
    }
    
    @Override
    public List<Item> findAll() {
        try {
            TypedQuery<Item> query = em.createNamedQuery(
                            "Item.findAll",
                            Item.class);
            return query.getResultList();
        } catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                FacesMessage.SEVERITY_WARN,
                e.getMessage(),
                e.getCause().getMessage());
            FacesContext
                .getCurrentInstance()
                .addMessage(null, m);
        }
        return new ArrayList<Item>();
    }
    
    @Override
    public List<Item> findItemsByQuery(Status status, String queryTerm){
    	try {
	    	TypedQuery<Item> query = em.createQuery(
	        		"FROM " + Item.class.getSimpleName() + " i "
	                        + "WHERE i.status = :status "
	                		+ "AND (i.title LIKE :term "
	                        + "OR i.description LIKE :term)",
	                Item.class);
	        query.setParameter("status", status);
	        query.setParameter("term", "%"+queryTerm+"%");
	        return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();
    }
    
    @Override
    public List<Item> findItemsByStatus(Status status){
    	try {
	    	TypedQuery<Item> query = em.createQuery(
	        		"FROM " + Item.class.getSimpleName() + " i "
	                        + "WHERE i.status = :status",
	                Item.class);
	        query.setParameter("status", status);
	        return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();
    }
    
    @Override
    public List<Item> findItemsByStatusAndBuyer(Status status, Customer buyer){
    	try {
	    	TypedQuery<Item> query = em.createQuery(
	                "FROM " + Item.class.getSimpleName() + " i "
	                        + "WHERE i.status= :status "
	                        + "AND i.buyer= :buyer",
	                Item.class);
	        query.setParameter("status", status);
	        query.setParameter("buyer", buyer);
	        return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();
    }
    
    @Override
    public List<Item> findItemsByStatusAndSeller(Status status, Customer seller){
    	try {
	    	TypedQuery<Item> query = em.createQuery(
	                "FROM " + Item.class.getSimpleName() + " i "
	                        + "WHERE i.seller = :seller "
	                		+ "AND i.status = :status",
	                Item.class);
	        query.setParameter("seller", seller);
	        query.setParameter("status", status);
	        return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();
    }
    
    @Override
    public List<Item> findItemsByTwoStatusesAndSeller(Status status1, Status status2, Customer seller){
    	try {
            TypedQuery<Item> query = em.createQuery(
                    "FROM " + Item.class.getSimpleName() + " i "
                            + "WHERE i.seller = :seller "
                    		+ "AND (i.status = :status1 "
                            + "OR i.status = :status2)",
                    Item.class);
            query.setParameter("seller", seller);
            query.setParameter("status1", status1);
            query.setParameter("status2", status2);
            return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();    	
    }
    
    @Override
    public List<Item> findItemsByStatusesAndSeller(Status status1, Status status2, Status status3, Customer seller){
    	try {
            TypedQuery<Item> query = em.createQuery(
                    "FROM " + Item.class.getSimpleName() + " i "
                            + "WHERE i.seller = :seller "
                    		+ "AND (i.status = :status1 "
                            + "OR i.status = :status2 "
                    		+ "OR i.status = :status3)",
                    Item.class);
            query.setParameter("seller", seller);
            query.setParameter("status1", status1);
            query.setParameter("status2", status2);
            query.setParameter("status3", status3);
            return query.getResultList();
    	}catch (Exception e) {
        	FacesMessage m = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    e.getMessage(),
                    e.getCause().getMessage());
                FacesContext
                    .getCurrentInstance()
                    .addMessage(null, m);
        }
        return new ArrayList<Item>();    	
    }
}

