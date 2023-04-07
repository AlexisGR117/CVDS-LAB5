package edu.eci.cvds.juego;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.juego.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean que maneja la interacciones del usuario con la pagina de incio de la aplicacion.
 * @author Jefer Gonzalez
 * @version 1.0 (03/04/2023)
 */
@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    private String nombre;
    //Inyeccion de las dependencias
    @Autowired
    ConfigurationService configurationService;
    @Autowired
    Juego juego;

    /**
     * Hace unas pruebas y obtiene el valor de la configuracion con propiedad "Premio" y
     * le asigna este valor al premio del juego.
     */
    public void ingresar() {
        //Pruebas :3
        System.out.println("\nObteniendo todas las configuraciones....");
        configurationService.getAllConfiguration().forEach(configuration -> System.out.println(configuration));

        System.out.println("\nObteniendo la configuracion con propiedad = 'Premio'....");
        System.out.println(configurationService.getConfiguration("Premio"));
        // Obtener el valor del premio al oprimir el valor y asignarselo al premio
        int premio = Integer.parseInt(configurationService.getConfiguration("Premio").getValor());
        juego.setPremio(premio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
}
