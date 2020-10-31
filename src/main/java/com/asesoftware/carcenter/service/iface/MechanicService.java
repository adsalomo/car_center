package com.asesoftware.carcenter.service.iface;

import com.asesoftware.carcenter.dto.MechanicDto;
import com.asesoftware.carcenter.exception.RestException;
import java.util.List;

/**
 * Interface definicion de los metodos servicio Mechanic
 * @author adrian
 */
public interface MechanicService {
    
    /**
     * Metodo que obtiene los registros de la tabla mecanicos
     * @return 
     * @throws RestException Excepcion levantada por un error en el proceso
     */
    List<MechanicDto> getAll() throws RestException;
    
    /**
     * Metodo para crear un nuevo Mecanico
     * @param mechanicDto Objeto MechanicDto
     * @throws RestException Excepcion levantada por un error en el proceso
     */
    void create(MechanicDto mechanicDto) throws RestException;
    
    /**
     * Obtiene los mecanicos para asignar mantenimientos
     * Verifica la disponibilidad teniendo en cuenta si esta libre o
     * si tuvo menos carga de trabajo en el ultimo mes.
     * @return List Mechanic
     * @throws RestException 
     */
    List<MechanicDto> getAvailableMechanics() throws RestException;
    
}
