package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.Mechanic;
import com.asesoftware.carcenter.model.MechanicPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository tabla mecanicos
 * @author adrian
 */
public interface MechanicRepository extends JpaRepository<Mechanic, MechanicPK> {
    
    /**
     * Realiza la busqueda por tipo y documento
     * @param mechanicPK Objecto MechanicPK
     * @return Mechanic
     */
    Mechanic findByMechanicPK(MechanicPK mechanicPK);
}
