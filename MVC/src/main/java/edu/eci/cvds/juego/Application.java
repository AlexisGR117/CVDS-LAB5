package edu.eci.cvds.juego;

import edu.eci.cvds.juego.model.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.cvds.juego.service.ConfigurationService;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.Collections;

/**
 * Clase principal de la Aplicación Spring Boot
 */
@SpringBootApplication
public class Application {
    @Autowired
    ConfigurationService configurationService;
    public static void main (String[] args) {
      SpringApplication.run(Application.class, args);
    }

    /**
     * Método que configura y registra el servlet de JSF en el contexto del servidor web.
     */
    @Bean
    ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
        //spring boot only works if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        //registration
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }

    /**
     * Agrega el registro a la base de datos cuando se inicia la aplicación y hace algunas pruebas.
     */
    @Bean
    public CommandLineRunner run() throws Exception {
        return (args) -> {
            //Se agrega el registro a la base de datos
            System.out.println("Agregando configuración....\n");
            configurationService.addConfiguration(new Configuration("Premio", "100000"));
            //Pruebas
            System.out.println("\nObteniendo todas las configuraciones....");
            configurationService.getAllConfiguration().forEach(System.out::println);
            System.out.println("\nObteniendo la configuración con propiedad = 'Premio'....");
            System.out.println(configurationService.getConfiguration("Premio"));
        };
    }
}
