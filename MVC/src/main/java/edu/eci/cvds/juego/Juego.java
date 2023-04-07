package edu.eci.cvds.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Juego de adivinar un numero aleatorio entre 1 y 20.
 * @author Jefer Gonzalez
 * @version 2.0 (03/04/2023)
 */
@Component
@ManagedBean(name = "juego")
@SessionScoped
public class Juego {

    private int numeroAdivinar, numero, intentos, premio;
    private String estado;
    private List<Integer> lista;

    /**
     * Contructor para objetos de clase Juego.
     */
    public Juego() {
        restart();
    }

    /**
     * Metodo que verifica que el numero guardado sea el numero establecido para adivinar.
     */
    public void guess() {
    	intentos++;
    	lista.add(numero);
        if (numero == numeroAdivinar) {
            estado = "Ganaste $" + premio + "!";
        } else {
        	if (!estado.contains("Ganaste $") && premio >= 10000) {
        		premio -= 10000;
        		estado = "Intenta de nuevo!";
        	}
        }
    }

    /**
     * Reinicia el juego restablenciendo los valores y estableciendo un nuevo numero a adivianr.
     */
    public void restart() {
        Random rand = new Random();
        numeroAdivinar = rand.nextInt(20) + 1;
        intentos = 0;
        premio = 100000;
        numero = 10;
        lista = new ArrayList<Integer>();
        estado = "Adivina el número entre 1 y 20!";
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar (int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero (int numero) {
        this.numero = numero;
    }

    public int getIntentos() {
        return intentos;
    }
    
    public void setIntentos (int intentos) {
        this.intentos = intentos;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio (int premio) {
        this.premio = premio;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado (String estado) {
        this.estado = estado;
    }
    
    public List<Integer> getLista() {
        return lista;
    }

    public void setLista (List<Integer> lista) {
        this.lista = lista;
    }
}
