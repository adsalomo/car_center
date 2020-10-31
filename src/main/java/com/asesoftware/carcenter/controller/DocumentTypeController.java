package com.asesoftware.carcenter.controller;

import com.asesoftware.carcenter.dto.DocumentTypeDto;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.service.iface.DocumentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que expone api para tipo documentos
 * @author adrian
 */
@RestController
@RequestMapping("/document-type")
@CrossOrigin("*")
public class DocumentTypeController {
    
    @Autowired
    private DocumentTypeService documentTypeService;
    
    /**
     * Servicio Get que retorna tipos de documentos
     * @return List DocumentTypeDto
     * @throws RestException 
     */
    @GetMapping
    public List<DocumentTypeDto> getAll() throws RestException {
        try {
            return this.documentTypeService.getAll();
        } catch (NotFoundException ex) {
            throw ex;
        }
    }
}
