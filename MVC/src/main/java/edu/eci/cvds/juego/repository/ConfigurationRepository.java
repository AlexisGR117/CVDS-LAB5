package edu.eci.cvds.juego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.cvds.juego.model.Configuration;

/**
 * Acceso a la base de datos, realiza operaciones de presistencia de base de datos.
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, String>{

}
