package com.asesoftware.carcenter.service.impl;

import com.asesoftware.carcenter.dto.DocumentTypeDto;
import com.asesoftware.carcenter.exception.ErrorDto;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.model.DocumentType;
import com.asesoftware.carcenter.repository.DocumentTypeRepository;
import com.asesoftware.carcenter.service.iface.DocumentTypeService;
import com.asesoftware.carcenter.util.ConstUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Implementacion interface DocumentTypeService
 * @author adrian
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;
    
    public DocumentTypeServiceImpl(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }
    
    @Override
    public List<DocumentTypeDto> getAll() throws RestException {
        List<DocumentType> documentTypes = this.documentTypeRepository.findAll();
        if (documentTypes == null || documentTypes.isEmpty()) {
            throw new NotFoundException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()));
        }
        
        List<DocumentTypeDto> documentTypeDtos = new ArrayList<>();
        
        documentTypes.stream().map((documentType) -> {
            DocumentTypeDto documentTypeDto = new DocumentTypeDto();
            documentTypeDto.setId(documentType.getId());
            documentTypeDto.setShortName(documentType.getShortName());
            documentTypeDto.setName(documentType.getName());
            return documentTypeDto;
        }).forEachOrdered((documentTypeDto) -> {
            documentTypeDtos.add(documentTypeDto);
        });
        
        return documentTypeDtos;
    }
    
}
