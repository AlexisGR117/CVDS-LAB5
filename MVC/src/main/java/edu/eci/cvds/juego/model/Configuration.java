package edu.eci.cvds.juego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * Entidad de base de datos que guarda la configuración del juego.
 * @author Jefer Gonzalez
 * @version 1.0 (03/04/2023)
 */
@Entity
public class Configuration {

	@Id
	private String propiedad;
	private String valor;

	/**
	 * Constructor vacío para objetos de clase Configuration.
	 */
	public Configuration () {}

	/**
	 * Constructor para objetos de clase Configuration.
	 * @param propiedad Nombre de la propiedad del juego.
	 * @param valor Valor que se le da a la propiedad del juego.
	 */
	public Configuration(String propiedad, String valor) {
		this.propiedad = propiedad;
		this.valor = valor;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Configuración [propiedad=" + propiedad + ", valor=" + valor + "]";
	}
}