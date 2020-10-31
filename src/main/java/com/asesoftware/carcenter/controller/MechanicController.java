package com.asesoftware.carcenter.controller;

import com.asesoftware.carcenter.dto.MechanicDto;
import com.asesoftware.carcenter.exception.BadRequestException;
import com.asesoftware.carcenter.exception.ErrorDto;
import com.asesoftware.carcenter.exception.InternalServerErrorException;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.service.iface.MechanicService;
import com.asesoftware.carcenter.util.ConstUtil;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que expone una api para las operaciones relacionadas con la
 * entidad mecanico
 *
 * @author adrian
 */
@RestController
@RequestMapping("/mechanic")
@CrossOrigin("*")
public class MechanicController {

    private static final Logger LOG = LoggerFactory.getLogger(MechanicController.class);
    
    @Autowired
    private MechanicService mechanicService;

    /**
     * Recurso que se encarga de obtener los mecanicos
     * @return List MechanicDto
     * @throws RestException 
     */
    @GetMapping
    public List<MechanicDto> getAll() throws RestException {
        try {
            return this.mechanicService.getAll();
        } catch (NotFoundException ex) {
            throw ex;
        }
    }

    /**
     * Recurso que se encarga de crear un nuevo registro
     * @param mechanicDto Objecto MechanicDto
     * @throws RestException 
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MechanicDto mechanicDto) throws RestException {
        try {
            this.mechanicService.create(mechanicDto);
        } catch (BadRequestException ex) {
            throw ex;
        } catch (Exception ex) {
            LOG.error("ERROR CREATE", ex);
            throw new InternalServerErrorException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()));
        }
    }
}
