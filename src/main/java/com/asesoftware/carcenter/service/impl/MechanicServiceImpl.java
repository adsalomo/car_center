package com.asesoftware.carcenter.service.impl;

import com.asesoftware.carcenter.dto.MechanicDto;
import com.asesoftware.carcenter.exception.BadRequestException;
import com.asesoftware.carcenter.exception.ErrorDto;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.model.DocumentType;
import com.asesoftware.carcenter.model.Mechanic;
import com.asesoftware.carcenter.model.MechanicPK;
import com.asesoftware.carcenter.repository.DocumentTypeRepository;
import com.asesoftware.carcenter.repository.MechanicRepository;
import com.asesoftware.carcenter.service.iface.MechanicService;
import com.asesoftware.carcenter.util.ConstUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Implementacion interface MechanicService Esta clase anota con la etiqueta
 *
 * @Service para indicarle a spring que es un componente
 *
 * @author adrian
 */
@Service
public class MechanicServiceImpl implements MechanicService {

    private MechanicRepository mechanicRepository;
    private DocumentTypeRepository documentTypeRepository;

    public MechanicServiceImpl(MechanicRepository mechanicRepository,
            DocumentTypeRepository documentTypeRepository) {
        this.mechanicRepository = mechanicRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public List<MechanicDto> getAll() throws RestException {
        List<MechanicDto> mechanicDtos = new ArrayList<>();
        List<Mechanic> mechanics = this.mechanicRepository.findAll();
        if (mechanics == null || mechanics.isEmpty()) {
            throw new NotFoundException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()));
        }

        mechanics.stream().map((mechanic) -> {
            MechanicDto dto = new MechanicDto();
            dto.setDocument(mechanic.getMechanicPK().getDocument());
            dto.setDocumentTypeId(mechanic.getDocumentTypeCode().getId());
            dto.setFirstName(mechanic.getFirstName());
            dto.setSecondName(mechanic.getSecondName());
            dto.setSurName(mechanic.getSurName());
            dto.setSecondSurName(mechanic.getSecondSurName());
            dto.setCellPhone(mechanic.getCellPhone());
            dto.setEmail(mechanic.getEmail());
            dto.setState(mechanic.getState());
            dto.setAddress(mechanic.getAddress());
            return dto;
        }).forEachOrdered((dto) -> {
            mechanicDtos.add(dto);
        });

        return mechanicDtos;
    }

    @Override
    public void create(MechanicDto mechanicDto) throws RestException {
        // Valida que exista el tipo documento enviado
        Optional<DocumentType> documentType = this.documentTypeRepository
                .findById(mechanicDto.getDocumentTypeId());
        if (!documentType.isPresent()) {
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_ERROR_DATA,
                    HttpStatus.NOT_FOUND.value()));
        }

        // Valida que no exista un mecanico con el mismo tipo y num documento
        Mechanic mechanic = this.mechanicRepository
                .findByMechanicPK(new MechanicPK(mechanicDto.getDocumentTypeId(),
                        mechanicDto.getDocument()));

        if (mechanic != null) {
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_EXISTS_MECHANIC,
                    HttpStatus.NOT_FOUND.value()));
        }

        mechanic = new Mechanic();
        mechanic.setMechanicPK(new MechanicPK(mechanicDto.getDocumentTypeId(),
                mechanicDto.getDocument()));
        mechanic.setFirstName(mechanicDto.getFirstName());
        mechanic.setSecondName(mechanicDto.getSecondName());
        mechanic.setSurName(mechanicDto.getSurName());
        mechanic.setSecondSurName(mechanic.getSecondSurName());
        mechanic.setCellPhone(mechanicDto.getCellPhone());
        mechanic.setAddress(mechanicDto.getAddress());
        mechanic.setEmail(mechanicDto.getEmail());
        mechanic.setState(mechanicDto.getState());
        this.mechanicRepository.save(mechanic);
    }

}
