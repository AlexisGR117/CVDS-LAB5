package edu.eci.cvds.juego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.juego.model.Configuration;
import edu.eci.cvds.juego.repository.ConfigurationRepository;

/**
 * Clase que se encarga de la lógica de negocio de la aplicacion.
 */
@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    /**
     * Constructor para objetos de clase Configurationservice.
     * @param configurationRepository Repositorio que accede a la base de datos.
     */
    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    /**
     * Agrega una nueva configuracion a la base de datos.
     * @param configuration Configuracion que se quiere agregar.
     * @return La configuracion que se agrego a la base de datos.
     */
    public Configuration addConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    /**
     * Obtiene la configuracion dada la propiedad.
     * @param configurationId Cadena con el nombre de la propiedad de la configuracion.
     * @return La configuracion que tiene la propiedad dada.
     */
    public Configuration getConfiguration(String configurationId) {
        return configurationRepository.findById(configurationId).get();
    }

    /**
     * Da todas las configuraciones que estan en la base de datos.
     * @return Lista con las configuraciones disponibles.
     */
    public List<Configuration> getAllConfiguration() {
        return configurationRepository.findAll();
    }

    /**
     * Actualiza una configuracion en la base de datos.
     * @param configuration Configuracion que se quiere actualizar.
     * @return La nueva configuracion actualizada.
     */
    public Configuration updateConfiguration(Configuration configuration) {
        if(configurationRepository.existsById(configuration.getPropiedad())) {
            return configurationRepository.save(configuration);
        }
        return null;
    }

    /**
     * Elimina una configuracion de la base de datos.
     * @param configurationId Nombre de la propiedad de la configuracion.
     */
    public void deleteConfiguration(String configurationId) {
        configurationRepository.deleteById(configurationId);
    }
}