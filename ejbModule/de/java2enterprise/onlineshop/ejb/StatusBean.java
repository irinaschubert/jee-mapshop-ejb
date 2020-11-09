package de.java2enterprise.onlineshop.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Status;

@Stateless
public class StatusBean implements StatusBeanLocal {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager em;
    
    @Override
    public Status findStatus(Long id) {
    	Status status = em.find(Status.class, id);
    	return status;
    }
}

