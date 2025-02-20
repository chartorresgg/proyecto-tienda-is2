package co.edu.poli.ejemplo1.controller;

import co.edu.poli.ejemplo1.model.Cliente;
import co.edu.poli.ejemplo1.services.ClienteImplementacionDAO;

/**
 * Controlador para gestionar las operaciones relacionadas con los clientes.
 */
public class ClienteController {
    private ClienteImplementacionDAO clienteDAO;
    
    /**
     * Constructor de la clase ClienteController.
     * Inicializa una instancia de ClienteImplementacionDAO para manejar las operaciones de base de datos.
     */
    public ClienteController() {
        clienteDAO = new ClienteImplementacionDAO();
    }
    
    /**
     * Crea un nuevo cliente con ID y nombre predefinidos y lo almacena en la base de datos.
     *
     * @return Un mensaje indicando que el cliente fue creado exitosamente junto con su ID.
     */
    public String Actioncrear() {
    	
        Cliente cliente = new Cliente("27", "Camila");
        clienteDAO.create(cliente);
        return "Cliente creado con ID: " + cliente.getId() + " y con nombre de cliente: " + cliente.getNombre();
    }
}