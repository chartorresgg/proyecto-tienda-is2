package co.edu.poli.ejemplo1.controller;

import java.io.IOException;
import java.sql.SQLException;
import co.edu.poli.ejemplo1.model.Cliente;
import co.edu.poli.ejemplo1.services.ClienteImplementacionDAO;
import co.edu.poli.ejemplo1.services.GenericDAO;

/**
 * Controlador para gestionar las operaciones relacionadas con los clientes.
 */
public class ClienteController {

	private GenericDAO<Cliente, String> clienteDAO; // Se usa la interfaz GenericDAO, para aplicar polimorfismo.

	/**
	 * Constructor de la clase ClienteController. Inicializa una instancia de
	 * ClienteImplementacionDAO para manejar las operaciones de base de datos.
	 */
	public ClienteController() {
		this.clienteDAO = new ClienteImplementacionDAO(); // Polimorfismo: asignación de una subclase a una variable de la superclase (interfaz).
	}

	/**
	 * Crea un nuevo cliente con ID y nombre predefinidos y lo almacena en la base
	 * de datos.
	 *
	 * @return Un mensaje indicando que el cliente fue creado exitosamente junto con
	 *         su ID.
	 * @throws IOException 
	 */
	public String crearCliente() throws IOException {
		Cliente cliente = new Cliente("51", "Isabel");
		try {
			clienteDAO.create(cliente);
			return "Cliente creado con ID: " + cliente.getId() + " y con nombre de cliente: " + cliente.getNombre();
		} catch (SQLException e) {
			return "Error al crear el cliente: " + e.getMessage();
		}
	}
}