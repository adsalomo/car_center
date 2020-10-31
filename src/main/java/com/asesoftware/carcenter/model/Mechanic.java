package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad mapeo tabla mecanicos de la base de datos
 *
 * @author adrian
 */
@Entity
@Table(name = "mecanicos")
public class Mechanic implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private MechanicPK mechanicPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_tipo_documento", insertable = false, updatable = false)
    private DocumentType documentTypeCode;

    @Column(name = "primer_nombre")
    private String firstName;

    @Column(name = "segundo_nombre")
    private String secondName;

    @Column(name = "primer_apellido")
    private String surName;

    @Column(name = "segundo_apellido")
    private String secondSurName;

    @Column(name = "celular")
    private String cellPhone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "estado")
    private char state;

    /**
     * @return the mechanicPK
     */
    public MechanicPK getMechanicPK() {
        return mechanicPK;
    }

    /**
     * @param mechanicPK the mechanicPK to set
     */
    public void setMechanicPK(MechanicPK mechanicPK) {
        this.mechanicPK = mechanicPK;
    }

    /**
     * @return the documentTypeCode
     */
    public DocumentType getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * @param documentTypeCode the documentTypeCode to set
     */
    public void setDocumentTypeCode(DocumentType documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the secondSurName
     */
    public String getSecondSurName() {
        return secondSurName;
    }

    /**
     * @param secondSurName the secondSurName to set
     */
    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    /**
     * @return the cellPhone
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellPhone the cellPhone to set
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the state
     */
    public char getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(char state) {
        this.state = state;
    }

}
