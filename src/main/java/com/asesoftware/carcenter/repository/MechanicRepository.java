package com.asesoftware.carcenter.repository;

import com.asesoftware.carcenter.model.Mechanic;
import com.asesoftware.carcenter.model.MechanicPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository tabla mecanicos
 *
 * @author adrian
 */
public interface MechanicRepository extends JpaRepository<Mechanic, MechanicPK> {

    /**
     * Realiza la busqueda por tipo y documento
     *
     * @param mechanicPK Objecto MechanicPK
     * @return Mechanic
     */
    Mechanic findByMechanicPK(MechanicPK mechanicPK);

    @Query(value = "select * "
            + "from mecanicos me "
            + "where me.cod_tipo_documento || ' ' || me.documento "
            + "	     not in (select m.mec_cod_tipo_documento  || ' ' || m.mec_documento "
            + "		     from mantenimientos m "
            + "		     where m.cod_estado_mantenimiento = 1)", nativeQuery = true)
    List<Mechanic> findAllAvailable();
}
