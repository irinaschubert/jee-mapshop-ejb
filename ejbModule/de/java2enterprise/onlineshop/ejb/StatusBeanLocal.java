package de.java2enterprise.onlineshop.ejb;

import java.io.Serializable;

import javax.ejb.Local;
import de.java2enterprise.onlineshop.model.Status;

@Local
public interface StatusBeanLocal extends Serializable {
    
    Status findStatus(Long id);
}
