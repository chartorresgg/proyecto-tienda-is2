package co.poli.edu.cguzman.controlador;

import java.sql.SQLException;

import co.poli.edu.cguzman.modelo.Cliente;
import co.poli.edu.cguzman.modelo.FoodProductFactory;
import co.poli.edu.cguzman.services.ClienteImplementacionDAO;
import co.poli.edu.cguzman.services.GenericDAO;

import co.poli.edu.cguzman.modelo.ProductFactory;
import co.poli.edu.cguzman.modelo.Producto;
import co.poli.edu.cguzman.services.ProductoDAO;
import co.poli.edu.cguzman.services.ProductoImplementacionDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controlador para el formulario de cliente.
 */
public class ControladorFormulario {

	@FXML
	private Button btn_guardar, btn_consultar, btn_eliminar, btn_actualizar, btn_guardar2, btn_consultar2,
			btn_eliminar2, btn_actualizar2;

	// Se usa la interfaz GenericDAO, para aplicar polimorfismo.
	@FXML
	private TextField txt_id, txt_nombres, txt_idproducto, txt_nombreproducto;

	// Se usa la interfaz GenericDAO, para aplicar polimorfismo.
	private GenericDAO<Cliente, String> clienteDAO = new ClienteImplementacionDAO();
	private ProductoDAO productoDAO = new ProductoImplementacionDAO();
	private ProductFactory productFactory = new FoodProductFactory(500);

	@FXML
	private void crearCliente(ActionEvent event) {

		String id = txt_id.getText(); // Obtiene
		String nombre = txt_nombres.getText();

		if (id.isEmpty() || nombre.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Nombre.");
			return;
		}

		Cliente cliente = new Cliente(id, nombre);
		try {
			clienteDAO.create(cliente);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Registrado",
					"Cliente creado con ID: " + id + " y Nombre: " + nombre);
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al crear el cliente", e.getMessage());
		}
	}

	@FXML
	private void actualizarCliente(ActionEvent event) {
		String id = txt_id.getText();
		String nombre = txt_nombres.getText();

		if (id.isEmpty() || nombre.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Nombre.");
			return;
		}

		try {
			Cliente clienteExistente = clienteDAO.read(id);
			if (clienteExistente == null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "No se encontró un cliente con ID: " + id);
				return;
			}

			clienteExistente.setNombre(nombre);
			clienteDAO.update(clienteExistente);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Actualizado",
					"Cliente con ID: " + id + " ahora tiene el nombre: " + nombre);
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al actualizar el cliente", e.getMessage());
		}
	}

	@FXML
	private void eliminarCliente(ActionEvent event) {
		String id = txt_id.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para eliminar.");
			return;
		}

		try {
			clienteDAO.delete(id);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Eliminado",
					"Cliente con ID " + id + " eliminado correctamente.");
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al eliminar el cliente", e.getMessage());
		}
	}

	@FXML
	private void consultarCliente(ActionEvent event) {
		String id = txt_id.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para consultar.");
			return;
		}

		try {
			Cliente cliente = clienteDAO.read(id);
			if (cliente != null) {
				txt_nombres.setText(cliente.getNombre());
				mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Encontrado",
						"ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre());
			} else {
				mostrarAlerta(Alert.AlertType.WARNING, "Consulta Fallida",
						"No se encontró un cliente con el ID: " + id);
			}
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al leer el cliente", e.getMessage());
		}
	}

	// Operaciones CRUD para Productos

	@FXML
	private void crearProducto(ActionEvent event) {

		String id = txt_idproducto.getText();
		String descripcion = txt_nombreproducto.getText();

		if (id.isEmpty() || descripcion.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Descripción.");
			return;
		}

		try {
			Producto producto = productFactory.createProducto(id, descripcion);
			productoDAO.create(producto);

			mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Registrado",
					"Producto creado con ID: " + id + " y Nombre: " + descripcion);
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al crear el producto", e.getMessage());
		}
	}

	@FXML
	private void actualizarProducto(ActionEvent event) {

		String id = txt_idproducto.getText();
		String descripcion = txt_nombreproducto.getText();

		if (id.isEmpty() || descripcion.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y descripción.");
			return;
		}

		try {
			Producto productoExistente = productoDAO.read(id);
			if (productoExistente == null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "No se encontró un producto con ID: " + id);
				return;
			}

			productoExistente.setDescripcion(descripcion);
			productoDAO.update(productoExistente);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Actualizado",
					"Producto con ID: " + id + " ahora tiene la descripción: " + descripcion);
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al actualizar el producto", e.getMessage());
		}

	}

	@FXML
	private void eliminarProducto(ActionEvent event) {

		String id = txt_idproducto.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para eliminar.");
			return;
		}

		try {
			productoDAO.delete(id);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Eliminado",
					"Producto con ID " + id + " eliminado correctamente.");
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al eliminar el producto", e.getMessage());
		}
	}

	@FXML
	private void consultarProducto(ActionEvent event) {

		String id = txt_idproducto.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para consultar.");
			return;
		}

		try {
			Producto producto = productoDAO.read(id);
			if (producto != null) {
				txt_nombreproducto.setText(producto.getDescripcion());
				mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Encontrado",
						"ID: " + producto.getId() + ", Descripción: " + producto.getDescripcion());
			} else {
				mostrarAlerta(Alert.AlertType.WARNING, "Consulta Fallida",
						"No se encontró un producto con el ID: " + id);
			}
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al leer el producto", e.getMessage());
		}
	}

	private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
		Alert alert = new Alert(tipo);
		alert.setTitle(titulo);
		alert.setContentText(mensaje);
		alert.show();
	}

	private void limpiarCampos() {
		txt_id.clear();
		txt_nombres.clear();
	}
}
