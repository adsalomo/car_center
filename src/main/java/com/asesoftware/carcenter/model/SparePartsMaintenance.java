package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad tabla repuestos_x_mantenimientos
 * @author adrian
 */
@Entity
@Table(name = "repuestos_x_mantenimientos")
public class SparePartsMaintenance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int id;

    @Column(name = "tiempo_estimado")
    private int estimatedTime;

    @Column(name = "unidades")
    private int units;

    @ManyToOne
    @JoinColumn(name = "cod_mantenimiento")
    private Maintenance maintenance;

    @ManyToOne
    @JoinColumn(name = "cod_repuesto")
    private SpareParts spareCode;

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
     * @return the estimatedTime
     */
    public int getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * @param estimatedTime the estimatedTime to set
     */
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    /**
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the maintenance
     */
    public Maintenance getMaintenance() {
        return maintenance;
    }

    /**
     * @param maintenance the maintenance to set
     */
    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    /**
     * @return the spareCode
     */
    public SpareParts getSpareCode() {
        return spareCode;
    }

    /**
     * @param spareCode the spareCode to set
     */
    public void setSpareCode(SpareParts spareCode) {
        this.spareCode = spareCode;
    }

}
