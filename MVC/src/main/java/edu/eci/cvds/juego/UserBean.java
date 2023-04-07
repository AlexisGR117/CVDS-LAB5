package edu.eci.cvds.juego;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.juego.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean que maneja la interacciones del usuario con la página de inicio de la aplicación.
 * @author Jefer Gonzalez
 * @version 1.0 (03/04/2023)
 */
@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    private String name;
    //Inyección de las dependencias
    @Autowired
    ConfigurationService configurationService;
    @Autowired
    Game game;

    /**
     * Hace unas pruebas y obtiene el valor de la configuración con propiedad "Premio" y
     * le asigna este valor al premio del juego.
     */
    public void enter() {
        //Pruebas :3
        System.out.println("\nObteniendo todas las configuraciones....");
        configurationService.getAllConfiguration().forEach(System.out::println);

        System.out.println("\nObteniendo la configuración con propiedad = 'Premio'....");
        System.out.println(configurationService.getConfiguration("Premio"));
        // Obtener el valor del premio al oprimir el valor y asignárselo al premio
        int prize = Integer.parseInt(configurationService.getConfiguration("Premio").getValor());
        game.setPrize(prize);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
