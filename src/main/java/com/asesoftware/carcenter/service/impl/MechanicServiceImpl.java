package com.asesoftware.carcenter.service.impl;

import com.asesoftware.carcenter.dto.MechanicDto;
import com.asesoftware.carcenter.exception.BadRequestException;
import com.asesoftware.carcenter.exception.ErrorDto;
import com.asesoftware.carcenter.exception.NotFoundException;
import com.asesoftware.carcenter.exception.RestException;
import com.asesoftware.carcenter.model.DocumentType;
import com.asesoftware.carcenter.model.Maintenance;
import com.asesoftware.carcenter.model.MaintenanceServices;
import com.asesoftware.carcenter.model.Mechanic;
import com.asesoftware.carcenter.model.MechanicPK;
import com.asesoftware.carcenter.model.SparePartsMaintenance;
import com.asesoftware.carcenter.repository.DocumentTypeRepository;
import com.asesoftware.carcenter.repository.MaintenanceRepository;
import com.asesoftware.carcenter.repository.MaintenanceServicesRepository;
import com.asesoftware.carcenter.repository.MechanicRepository;
import com.asesoftware.carcenter.repository.SparePartsMaintRepository;
import com.asesoftware.carcenter.service.iface.MechanicService;
import com.asesoftware.carcenter.util.ConstUtil;
import com.asesoftware.carcenter.util.Utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private MaintenanceRepository mainRepository;
    @Autowired
    private MaintenanceServicesRepository servicesRepository;
    @Autowired
    private SparePartsMaintRepository spareRepository;

    @Override
    public List<MechanicDto> getAll() throws RestException {
        List<Mechanic> mechanics = this.mechanicRepository.findAll();
        if (mechanics == null || mechanics.isEmpty()) {
            throw new NotFoundException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()));
        }

        List<MechanicDto> mechanicDtos = new ArrayList<>();

        Utils.setMapValuesMechanic(mechanics, mechanicDtos);

        return mechanicDtos;
    }

    @Override
    public void create(MechanicDto mechanicDto) throws RestException {
        // Valida numero documento minimo 6 digitos
        if (mechanicDto.getDocument() < 6) {
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_ERROR_DATA,
                    HttpStatus.BAD_REQUEST.value()));
        }

        // Valida que exista el tipo documento enviado
        Optional<DocumentType> documentType = this.documentTypeRepository
                .findById(mechanicDto.getDocumentTypeId());
        if (!documentType.isPresent()) {
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_ERROR_DATA,
                    HttpStatus.BAD_REQUEST.value()));
        }

        // Valida que no exista un mecanico con el mismo tipo y num documento
        Mechanic mechanic = this.mechanicRepository
                .findByMechanicPK(new MechanicPK(mechanicDto.getDocumentTypeId(),
                        mechanicDto.getDocument()));

        if (mechanic != null) {
            throw new BadRequestException(ErrorDto.getErrorDto(
                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    ConstUtil.MESSAGE_EXISTS_MECHANIC,
                    HttpStatus.BAD_REQUEST.value()));
        }

        mechanic = new Mechanic();
        mechanic.setMechanicPK(new MechanicPK(mechanicDto.getDocumentTypeId(),
                mechanicDto.getDocument()));
        mechanic.setFirstName(mechanicDto.getFirstName());
        mechanic.setSecondName(mechanicDto.getSecondName());
        mechanic.setSurName(mechanicDto.getSurName());
        mechanic.setSecondSurName(mechanicDto.getSecondSurName());
        mechanic.setCellPhone(mechanicDto.getCellPhone());
        mechanic.setAddress(mechanicDto.getAddress());
        mechanic.setEmail(mechanicDto.getEmail());
        mechanic.setState(mechanicDto.getState());
        this.mechanicRepository.save(mechanic);
    }

    @Override
    public List<MechanicDto> getAvailableMechanics() throws RestException {
        // Obtiene los mecanicos que no tengan una mantenimiento activo
        List<Mechanic> mechanics = this.mechanicRepository.findAllAvailable();
        if (mechanics == null || mechanics.isEmpty()) {
            throw new NotFoundException(ErrorDto.getErrorDto(
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND,
                    HttpStatus.NOT_FOUND.value()));
        }

        List<MechanicDto> mechanicDtos = new ArrayList<>();

        // Con base a la fecha actual, toma el ultimo mes
        // Saca la fecha inicio del ultimo mes y la fecha fin
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDate = currentDate.minusMonths(1);
        LocalDate startDate = LocalDate.of(lastDate.getYear(), lastDate.getMonth(), 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        for (Mechanic mechanic : mechanics) {
            // Busca por mecanico todos los mantenimientos que hizo en el ultimo mes
            List<Maintenance> maintenances = this.mainRepository
                    .findByMechanicAndMaintenanceDateBetween(mechanic, startDate, endDate);
            if (maintenances == null || maintenances.isEmpty()) {
                mechanicDtos.add(Utils.getMapValuesMechanic(mechanic));
            } else {
                int time = 0;

                for (Maintenance maintenance : maintenances) {
                    // Contador tiempos de repuestos
                    List<SparePartsMaintenance> spares = this.spareRepository
                            .findByMaintenance(maintenance);
                    if (spares != null && spares.size() > 0) {
                        for (SparePartsMaintenance spare : spares) {
                            time += spare.getEstimatedTime();
                        }
                    }

                    // Contador tiempos de servicio
                    List<MaintenanceServices> services = this.servicesRepository
                            .findByMaintenance(maintenance);
                    if (services != null && services.size() > 0) {
                        for (MaintenanceServices service : services) {
                            time += service.getEstimatedTime();
                        }
                    }
                }

                // Asigna el tiempo
                MechanicDto mechanicDto = Utils.getMapValuesMechanic(mechanic);
                mechanicDto.setTimeWorked(time);
                mechanicDtos.add(mechanicDto);
            }
        }

        // Sort mecanicos por tiempo trabajo
        mechanicDtos.sort(Comparator.comparing(MechanicDto::getTimeWorked));

        // Unicamente se listan los 10 primeros registros
        if (mechanicDtos.size() > 10) {
            return mechanicDtos.subList(0, 10);
        }

        return mechanicDtos;
    }

}
