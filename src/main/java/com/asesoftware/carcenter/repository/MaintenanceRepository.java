package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.Maintenance;
import com.asesoftware.carcenter.model.Mechanic;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio tabla mantenimientos
 * @author adrian
 */
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>{
    
    /**
     * Obtiene los mantenimientos por mecanico del ultimo mes
     * @param mechanic
     * @param startDate Fecha inicio periodo
     * @param endDate Fecha fin periodo
     * @return 
     */
    List<Maintenance> findByMechanicAndMaintenanceDateBetween(Mechanic mechanic, 
            LocalDate startDate, LocalDate endDate);
}
