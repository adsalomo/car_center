package com.asesoftware.carcenter.service.iface;

import com.asesoftware.carcenter.dto.DocumentTypeDto;
import com.asesoftware.carcenter.exception.RestException;
import java.util.List;

/**
 * Interface DocumentTypeService
 * @author adrian
 */
public interface DocumentTypeService {
    
    /**
     * Obtiene lista de tipos de documentos
     * @return List DocumentTypeDto
     * @throws RestException 
     */
    List<DocumentTypeDto> getAll() throws RestException;
}
