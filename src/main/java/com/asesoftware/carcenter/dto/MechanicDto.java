package com.asesoftware.carcenter.dto;

import javax.validation.constraints.NotBlank;

/**
 * Dto Mechanic
 *
 * @author adrian
 */
public class MechanicDto {

    private int document;
    private int documentTypeId;
    private String documentTypeName;
    @NotBlank(message = "Primer nombre es requerido")
    private String firstName;
    private String secondName;
    @NotBlank(message = "Primer apellido es requerido")
    private String surName;
    private String secondSurName;
    @NotBlank(message = "Teléfono es requerido")
    private String cellPhone;
    @NotBlank(message = "Dircción es requerido")
    private String address;
    @NotBlank(message = "Email es requerido")
    private String email;
    private char state;
    private long timeWorked;

    public MechanicDto() {
    }

    /**
     * @return the documentTypeId
     */
    public int getDocumentTypeId() {
        return documentTypeId;
    }

    /**
     * @param documentTypeId the documentTypeId to set
     */
    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    /**
     * @return the documentTypeName
     */
    public String getDocumentTypeName() {
        return documentTypeName;
    }

    /**
     * @param documentTypeName the documentTypeName to set
     */
    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
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

    /**
     * @return the document
     */
    public int getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(int document) {
        this.document = document;
    }

    /**
     * @return the timeWorked
     */
    public long getTimeWorked() {
        return timeWorked;
    }

    /**
     * @param timeWorked the timeWorked to set
     */
    public void setTimeWorked(long timeWorked) {
        this.timeWorked = timeWorked;
    }

}
