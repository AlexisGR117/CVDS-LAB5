package edu.eci.cvds;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "UserBean")
@SessionScoped
public class UserBean {

    private String nombre;

    public UserBean() {
    	nombre = null;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
}
