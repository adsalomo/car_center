package com.asesoftware.carcenter.controller;

import com.asesoftware.carcenter.dto.DocumentTypeDto;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.service.iface.DocumentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/document-type", description = "Gestión api tipos de documento.")
public class DocumentTypeController {
    
    @Autowired
    private DocumentTypeService documentTypeService;
    
    /**
     * Servicio Get que retorna tipos de documentos
     * @return List DocumentTypeDto
     * @throws RestException 
     */
     @ApiOperation(value = "Obtiene los tipos de documentos registrados en el sistema del sistema",
            response = DocumentTypeDto.class,
            responseContainer = "List",
            httpMethod = "GET")
    @GetMapping
    public List<DocumentTypeDto> getAll() throws RestException {
        try {
            return this.documentTypeService.getAll();
        } catch (NotFoundException ex) {
            throw ex;
        }
    }
}
