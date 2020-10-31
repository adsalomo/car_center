package com.asesoftware.carcenter.service.impl;

import com.asesoftware.carcenter.model.Mechanic;
import com.asesoftware.carcenter.model.MechanicPK;
import com.asesoftware.carcenter.repository.DocumentTypeRepository;
import com.asesoftware.carcenter.repository.MechanicRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 * Prueba unitaria servicio impl Mechanic
 *
 * @author adrian
 */
public class MechanicServiceImplTest {

    @InjectMocks
    MechanicServiceImplTest mechanicServiceImpl;
    @Mock
    MechanicRepository mechanicRepository;
    @Mock
    DocumentTypeRepository documentTypeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll() {

        List<Mechanic> mechanics = new ArrayList<>();
        Mechanic mechanic = new Mechanic();
        mechanic.setMechanicPK(new MechanicPK(1, 123456));
        mechanic.setAddress("Calle 49");
        mechanic.setCellPhone("3185235696");
        mechanic.setEmail("johndoe@gmail.com");
        mechanic.setFirstName("John");
        mechanic.setSurName("Doe");
        mechanics.add(mechanic);

        when(this.mechanicRepository.findAll()).thenReturn(mechanics);
        
        List<Mechanic> mechanicsTest = this.mechanicRepository.findAll();
        assertEquals(1, mechanicsTest.size());
    }

}
