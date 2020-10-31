package com.asesoftware.carcenter.dto;

/**
 * Dto Mechanic
 *
 * @author adrian
 */
public class MechanicDto {

    private int document;
    private int documentTypeId;
    private String documentTypeName;
    private String firstName;
    private String secondName;
    private String surName;
    private String secondSurName;
    private String cellPhone;
    private String address;
    private String email;
    private char state;

    public MechanicDto() {
    }

    public MechanicDto(int document, int documentTypeId, String documentTypeName,
            String firstName, String secondName, String surName,
            String secondSurName, String cellPhone, String address, String email, char state) {
        this.document = document;
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.secondSurName = secondSurName;
        this.cellPhone = cellPhone;
        this.address = address;
        this.email = email;
        this.state = state;
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

}
