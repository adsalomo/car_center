package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity mapeo tabla tipo documento
 *
 * @author adrian
 */
@Entity
@Table(name = "tipo_documento")
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "codigo")
    private int id;

    @Column(name = "nombre_corto")
    private String shortName;

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
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
