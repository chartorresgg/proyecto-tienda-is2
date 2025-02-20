package co.edu.poli.ejemplo1.controller;

import java.sql.SQLException;

import co.edu.poli.ejemplo1.model.Producto;
import co.edu.poli.ejemplo1.services.GenericDAO;
import co.edu.poli.ejemplo1.services.ProductoImplementacionDAO;

/**
 * Controlador para gestionar las operaciones relacionadas con los productos.
 */
public class ProductoController {
	private GenericDAO<Producto, String> productoDAO; // Se usa la interfaz DAOCrud

	/**
	 * Constructor de la clase ProductoController. Inicializa una instancia de
	 * ProductoImplementacionDAO para manejar las operaciones de base de datos.
	 */
	public ProductoController() {
		productoDAO = new ProductoImplementacionDAO(); // Polimorfismo: instancia concreta
	}

	/**
	 * Crea un nuevo producto con ID y nombre predefinidos y lo almacena en la base
	 * de datos.
	 *
	 * @return Un mensaje indicando que el producto fue creado exitosamente junto
	 *         con su ID y nombre.
	 */
	public String crearProducto() {

		Producto producto = new Producto("iMac", "iMac 29 pulgadas");
		try {
			productoDAO.create(producto);
			return "Producto creado con ID: " + producto.getId() + " y con nombre: " + producto.getDescripcion();
		} catch (SQLException e) {
			return "Error al crear el producto: " + e.getMessage();
		}

	}
}