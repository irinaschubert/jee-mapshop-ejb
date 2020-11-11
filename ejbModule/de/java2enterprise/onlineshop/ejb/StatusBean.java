package de.java2enterprise.onlineshop.ejb;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.java2enterprise.onlineshop.model.Status;

@Stateless
public class StatusBean implements StatusBeanLocal {

	private static final long serialVersionUID = 1L;
    
    private final static Logger log = Logger.getLogger(StatusBean.class.toString());
	
	@PersistenceContext
    private EntityManager em;
    
    @Override
    public Status findStatus(Long id) {
    	try {
    		Status status = em.find(Status.class, id);
    	return status;
    	}catch(Exception e) {
    		log.severe(e.getMessage());
    	}
    	return null;
    }
}

