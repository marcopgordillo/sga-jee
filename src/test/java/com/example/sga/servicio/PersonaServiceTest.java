/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.servicio;

import com.example.sga.domain.Persona;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

/**
 *
 * @author mgordillo
 */
public class PersonaServiceTest {
    
    private PersonaService personaService;
    
    @Before
    public void setUp() throws Exception {
        EJBContainer contenedor = EJBContainer.createEJBContainer();
        personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!com.example.sga.servicio.PersonaService");
    }
    
    @Ignore
    @Test
    public void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null);
        assertEquals(4, personaService.listarPersonas().size());
        System.out.println("El no. de personas es igual a:" + personaService.listarPersonas().size());
        this.desplegarPersonas(personaService.listarPersonas());
        System.out.println("Fin test EJB PersonaService");
    }

    private void desplegarPersonas(List<Persona> personas) {
        personas.forEach((persona) -> System.out.println(persona));
    }
}
