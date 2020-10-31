package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio definicion DAO table tipo documento
 * @author adrian
 */
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer>{
    
}
