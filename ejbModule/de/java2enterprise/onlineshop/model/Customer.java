package de.java2enterprise.onlineshop.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(schema="MAPSHOP", name="CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name="CUSTOMER_ID_GENERATOR", 
            sequenceName="SEQ_CUSTOMER",
            schema="MAPSHOP",
            allocationSize=1,
            initialValue=1)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, 
            generator="CUSTOMER_ID_GENERATOR")
    private Long id;

    private String email;

    private String password;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
