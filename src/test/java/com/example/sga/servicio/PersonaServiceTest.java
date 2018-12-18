/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.servicio;

import com.example.sga.domain.Persona;
import com.example.sga.domain.Usuario;
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
    private UsuarioService usuarioService;
    
    EJBContainer contenedor;
    
    @Before
    public void setUp() throws Exception {
        contenedor = EJBContainer.createEJBContainer();
        System.out.println("Abriendo contenedor embebido Glassfish");
        personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!com.example.sga.servicio.PersonaService");
        usuarioService = (UsuarioService) contenedor.getContext().lookup("java:global/classes/UsuarioServiceImpl!com.example.sga.servicio.UsuarioService");
    }
    
    @Ignore
    @Test
    public void testEJB() {
        this.testEJBPersonaService();
        this.testEJBUsuarioService();
    }

    
    private void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(personaService != null);

        assertEquals(4, personaService.listarPersonas().size());

        System.out.println("El no. de personas es igual a:" + personaService.listarPersonas().size());

        this.desplegarPersonas(personaService.listarPersonas());
        System.out.println("Fin test EJB PersonaService");
    }

    private void testEJBUsuarioService() {
        System.out.println("Iniciando test EJB UsuarioService");
        assertTrue(usuarioService != null);

        assertEquals(2, usuarioService.listarUsuarios().size());

        System.out.println("El no. de usuarios es igual a:" + usuarioService.listarUsuarios().size());

        this.desplegarUsuarios(usuarioService.listarUsuarios());
        System.out.println("Fin test EJB UsuarioService");
    }

    private void desplegarUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    private void desplegarPersonas(List<Persona> personas) {

        for (Persona p : personas) {
            System.out.println(p);
        }
        //Esto genera un error ya que el servidor embebido no soporta Java 8
        //personas.forEach((persona) -> {
        //    System.out.println(persona);
        //});
    }
}
