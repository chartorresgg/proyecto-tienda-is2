package co.poli.edu.cguzman.controlador;

import co.poli.edu.cguzman.modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorFormulario {

	@FXML
	private Button btn_guardar;

	@FXML
	private Button btn_consultar;

	@FXML
	private Button btn_eliminar; // ✅ Agregado para evitar el error

	@FXML
	private Button btn_actualizar; // ✅ Agregado para evitar el error

	@FXML
	private TextField txt_id;

	@FXML
	private TextField txt_nombres;

	private ClienteController clienteController = new ClienteController();

	@FXML
	private void click(ActionEvent event) {
		String id = txt_id.getText();
		String nombre = txt_nombres.getText();

		if (id.isEmpty() || nombre.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Nombre.");
			return;
		}

		// Corregimos la llamada a createClient para pasar los parámetros correctamente
		String mensaje = clienteController.createClient(id, nombre);
		mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Registrado", mensaje);

		limpiarCampos();
	}

	@FXML
	private void actualizarCliente(ActionEvent event) {
		String id = txt_id.getText();
		String nombre = txt_nombres.getText();

		if (id.isEmpty() || nombre.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Nombre.");
			return;
		}

		// Llamamos al método de actualización en ClienteController (debes
		// implementarlo)
		String mensaje = clienteController.updateClient(id, nombre);
		mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Actualizado", mensaje);

		limpiarCampos();
	}

	@FXML
	private void eliminarCliente(ActionEvent event) {
		String id = txt_id.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para eliminar.");
			return;
		}

		try {
			clienteController.delete(id);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Eliminado",
					"Cliente con ID " + id + " eliminado correctamente.");
			limpiarCampos();
		} catch (Exception e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al eliminar",
					"No se pudo eliminar el cliente: " + e.getMessage());
		}
	}

	@FXML
	private void consultarCliente(ActionEvent event) {
		String id = txt_id.getText();

		if (id.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar un ID para consultar.");
			return;
		}

		String resultado = clienteController.read(id);

		if (resultado.startsWith("Cliente encontrado")) {
			// Extraer el nombre del cliente del resultado
			String[] partes = resultado.split(", Nombre = ");
			if (partes.length == 2) {
				txt_nombres.setText(partes[1]); // Mostrar el nombre en el campo de texto
			}
			mostrarAlerta(Alert.AlertType.INFORMATION, "Consulta Exitosa", resultado);
		} else {
			mostrarAlerta(Alert.AlertType.WARNING, "Consulta Fallida", resultado);
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