/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asesoftware.carcenter.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "mantenimientos")
public class Maintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int id;

    @Column(name = "fecha")
    private LocalDate maintenanceDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_placa")
    private Car car;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "mec_cod_tipo_documento", referencedColumnName = "cod_tipo_documento"),
        @JoinColumn(name = "mec_documento", referencedColumnName = "documento")
    })
    private Mechanic mechanic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_estado_mantenimiento")
    private MaintenanceStatus status;

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
     * @return the maintenanceDate
     */
    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    /**
     * @param maintenanceDate the maintenanceDate to set
     */
    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    /**
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @return the mechanic
     */
    public Mechanic getMechanic() {
        return mechanic;
    }

    /**
     * @param mechanic the mechanic to set
     */
    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    /**
     * @return the status
     */
    public MaintenanceStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

}
