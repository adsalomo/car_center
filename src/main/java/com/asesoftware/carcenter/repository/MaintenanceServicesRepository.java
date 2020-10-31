package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.Maintenance;
import com.asesoftware.carcenter.model.MaintenanceServices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio servicios por mantenimiento
 * @author adrian
 */
public interface MaintenanceServicesRepository extends JpaRepository<MaintenanceServices, Integer>{
    
    /**
     * Obtiene los servicios por mantenimiento
     * @param maintenance
     * @return 
     */
    List<MaintenanceServices> findByMaintenance(Maintenance maintenance);
}
