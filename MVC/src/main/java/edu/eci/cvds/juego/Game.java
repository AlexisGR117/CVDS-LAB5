package edu.eci.cvds.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Juego de adivinar un numero aleatorio entre 1 y 20.
 * @author Jefer Gonzalez
 * @version 2.0 (03/04/2023)
 */
@Component
@ManagedBean(name = "game")
@SessionScoped
public class Game {

    private int numberGuess, number, attempts, prize;
    private String state;
    private List<Integer> list;

    /**
     * Constructor para objetos de clase Juego.
     */
    public Game() {
        restart();
    }

    /**
     * Método que verifica que el número guardado sea el número establecido para adivinar.
     */
    public void guess() {
    	attempts++;
    	list.add(number);
        if (number == numberGuess) {
            state = "Ganaste $" + prize + "!";
        } else {
        	if (!state.contains("Ganaste $") && prize >= 10000) {
        		prize -= 10000;
        		state = "Intenta de nuevo!";
        	}
        }
    }

    /**
     * Reinicia el juego restableciendo los valores y estableciendo un nuevo número a adivinar.
     */
    public void restart() {
        Random rand = new Random();
        numberGuess = rand.nextInt(20) + 1;
        attempts = 0;
        prize = 200000; //
        number = 10;
        list = new ArrayList<Integer>();
        state = "Adivina el número entre 1 y 20!";
    }

    public int getNumberGuess() {
        return numberGuess;
    }

    public void setNumberGuess (int numberGuess) {
        this.numberGuess = numberGuess;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAttempts() {
        return attempts;
    }
    
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
