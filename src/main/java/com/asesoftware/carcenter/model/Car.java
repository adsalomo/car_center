package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity mapeo tabla vehiculos
 *
 * @author adrian
 */
@Entity
@Table(name = "vehiculos")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "placa")
    private String id;

    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_marca")
    private CarBrand carBrand;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cli_cod_tipo_documento", referencedColumnName = "cod_tipo_documento"),
        @JoinColumn(name = "cli_documento", referencedColumnName = "documento")
    })
    private Client client;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the carBrand
     */
    public CarBrand getCarBrand() {
        return carBrand;
    }

    /**
     * @param carBrand the carBrand to set
     */
    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
