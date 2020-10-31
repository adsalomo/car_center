package com.asesoftware.carcenter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Definicion de la llave compuesta de la tabla mecanicos
 *
 * @author adrian
 */
@Embeddable
public class MechanicPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cod_tipo_documento")
    private int documentTypeCode;
    @Column(name = "documento")
    private int document;

    public MechanicPK(int documentTypeCode, int document) {
        this.documentTypeCode = documentTypeCode;
        this.document = document;
    }

    public MechanicPK() {

    }

    /**
     * @return the documentTypeCode
     */
    public int getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * @param documentTypeCode the documentTypeCode to set
     */
    public void setDocumentTypeCode(int documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
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
