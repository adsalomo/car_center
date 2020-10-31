package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity mapeo tabla estado mantenimiento
 *
 * @author adrian
 */
@Entity
@Table(name = "estado_mantenimiento")
public class MaintenanceStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codigo")
    private int id;

    @Column(name = "nombre")
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
