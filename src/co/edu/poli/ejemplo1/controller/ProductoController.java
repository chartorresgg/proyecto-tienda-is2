package co.edu.poli.ejemplo1.controller;

import java.sql.SQLException;
import co.edu.poli.ejemplo1.model.ProductFactory;
import co.edu.poli.ejemplo1.model.Producto;
import co.edu.poli.ejemplo1.services.GenericDAO;
import co.edu.poli.ejemplo1.services.ProductoDAO;
import co.edu.poli.ejemplo1.services.ProductoImplementacionDAO;

/**
 * Controlador para gestionar las operaciones relacionadas con los productos. Se
 * encarga de la creación de productos y su almacenamiento en la base de datos.
 */
public class ProductoController {

	// Interfaz DAO que permite la manipulación de productos en la base de datos
	// mediante polimorfismo.
	private ProductoDAO productoDAO;

	// Fábrica de productos utilizada para instanciar diferentes tipos de productos.
	private ProductFactory productoFactory;

	/**
	 * Constructor de la clase ProductoController. Inicializa una instancia de
	 * ProductoImplementacionDAO para manejar las operaciones de base de datos y
	 * permite la inyección de una fábrica de productos.
	 *
	 * @param productoFactory Fábrica específica para la creación de productos (Ej.
	 *                        Alimento o Eléctrico).
	 */
	public ProductoController(ProductFactory productoFactory) {

		this.productoDAO = new ProductoImplementacionDAO();
		this.productoFactory = productoFactory;
	}

	/**
	 * Crea un nuevo producto con el ID y la descripción proporcionados y lo
	 * almacena en la base de datos.
	 *
	 * @param id          Identificador único del producto.
	 * @param descripcion Descripción o nombre del producto.
	 * @return Un mensaje confirmando la creación del producto junto con su
	 *         información.
	 */
	public String createProduct(String id, String descripcion) {
		// Verifica si la fábrica de productos está definida antes de intentar crear un
		// producto.
		if (productoFactory == null) {
			return "Error: No se ha definido una fábrica de productos.";
		}

		try {
			// Se crea un producto utilizando la fábrica específica inyectada.
			Producto producto = productoFactory.createProducto(id, descripcion);

			// Se almacena el producto en la base de datos.
			productoDAO.create(producto);

			// Devuelve un mensaje indicando que el producto fue creado exitosamente.
			return "Producto creado en la base de datos: " + producto.toString();
		} catch (SQLException e) {
			// Captura y lanza una excepción en caso de error en la base de datos.
			return "Error al guardar el producto en la base de datos: " + e.getMessage();
		}
	}
}