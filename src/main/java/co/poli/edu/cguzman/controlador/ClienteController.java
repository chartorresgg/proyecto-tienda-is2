package co.poli.edu.cguzman.controlador;

import java.io.IOException;
import java.sql.SQLException;

import co.poli.edu.cguzman.modelo.Cliente;
import co.poli.edu.cguzman.services.GenericDAO;
import co.poli.edu.cguzman.services.ClienteImplementacionDAO;

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
		this.clienteDAO = new ClienteImplementacionDAO(); // Polimorfismo: asignación de una subclase a una variable de
															// la superclase (interfaz).
	}

//	/**
//	 * Crea un nuevo cliente con ID y nombre predefinidos y lo almacena en la base
//	 * de datos.
//	 *
//	 * @return Un mensaje indicando que el cliente fue creado exitosamente junto con
//	 *         su ID.
//	 * @throws IOException
//	 */
//	public String crearCliente() throws IOException {
//		Cliente cliente = new Cliente("55", "M");
//		try {
//			clienteDAO.create(cliente);
//			return "Cliente creado con ID: " + cliente.getId() + " y con nombre de cliente: " + cliente.getNombre();
//		} catch (SQLException e) {
//			return "Error al crear el cliente: " + e.getMessage();
//		}
//	}

	public String createClient(String id, String nombre) {
		Cliente cliente = new Cliente(id, nombre);
		try {
			clienteDAO.create(cliente);
			return "Cliente creado con ID: " + cliente.getId() + " y con nombre de cliente: " + cliente.getNombre();
		} catch (SQLException e) {
			return "Error al crear el cliente: " + e.getMessage();
		}
	}

	/**
	 * Actualiza el nombre de un cliente en la base de datos.
	 */
	public String updateClient(String id, String nuevoNombre) {
		try {
			// Buscar cliente por ID
			Cliente clienteExistente = clienteDAO.read(id);

			if (clienteExistente == null) {
				return "No se encontró un cliente con el ID: " + id;
			}

			// Actualizar el nombre del cliente
			clienteExistente.setNombre(nuevoNombre);
			clienteDAO.update(clienteExistente);

			return "Cliente actualizado con ID: " + id + " y nuevo nombre: " + nuevoNombre;
		} catch (SQLException e) {
			return "Error al actualizar el cliente: " + e.getMessage();
		}
	}

	/**
	 * Elimina un cliente por su ID
	 */
	public String delete(String id) {
		try {
			clienteDAO.delete(id);
			return "Cliente con ID " + id + " eliminado correctamente.";
		} catch (SQLException e) {
			return "Error al eliminar el cliente: " + e.getMessage();
		}
	}

	public String read(String id) {
		try {
			Cliente cliente = clienteDAO.read(id);
			if (cliente != null) {
				return "Cliente encontrado: ID = " + cliente.getId() + ", Nombre = " + cliente.getNombre();
			} else {
				return "No se encontró un cliente con el ID: " + id;
			}
		} catch (Exception e) {
			return "Error al leer el cliente: " + e.getMessage();
		}
	}

}