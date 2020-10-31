package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.Maintenance;
import com.asesoftware.carcenter.model.SparePartsMaintenance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository repuestos_x_mantenimientos
 * @author adrian
 */
public interface SparePartsMaintRepository extends JpaRepository<SparePartsMaintenance, Integer>{
    
    /**
     * Obtiene los repuestos por mantenimiento
     * @param maintenance
     * @return 
     */
    List<SparePartsMaintenance> findByMaintenance(Maintenance maintenance);
}
