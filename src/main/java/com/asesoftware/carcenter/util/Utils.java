package com.asesoftware.carcenter.util;

import com.asesoftware.carcenter.dto.MechanicDto;
import com.asesoftware.carcenter.model.Mechanic;
import java.util.List;

/**
 * Clase utilitaria para metodos tranversales en la app
 *
 * @author adrian
 */
public class Utils {

    private Utils() {

    }

    /**
     * Recibe por referencia una instancia de List para mapear su resultado al
     * Dto Mechanic
     *
     * @param mechanics List
     * @param mechanicDtos List
     */
    public static void setMapValuesMechanic(List<Mechanic> mechanics,
            List<MechanicDto> mechanicDtos) {
        mechanics.stream().map((mechanic) -> {
            MechanicDto dto = getMapValuesMechanic(mechanic);
            return dto;
        }).forEachOrdered((dto) -> {
            mechanicDtos.add(dto);
        });
    }

    /**
     * Recibe por referencia una instancia de List para mapear su resultado al
     * Dto Mechanic
     * @param mechanic
     * @return 
     */
    public static MechanicDto getMapValuesMechanic(Mechanic mechanic) {
        MechanicDto dto = new MechanicDto();
        dto.setDocument(mechanic.getMechanicPK().getDocument());
        dto.setDocumentTypeId(mechanic.getDocumentTypeCode().getId());
        dto.setDocumentTypeName(mechanic.getDocumentTypeCode().getName());
        dto.setFirstName(mechanic.getFirstName());
        dto.setSecondName(mechanic.getSecondName());
        dto.setSurName(mechanic.getSurName());
        dto.setSecondSurName(mechanic.getSecondSurName());
        dto.setCellPhone(mechanic.getCellPhone());
        dto.setEmail(mechanic.getEmail());
        dto.setState(mechanic.getState());
        dto.setAddress(mechanic.getAddress());
        return dto;
    }
}
