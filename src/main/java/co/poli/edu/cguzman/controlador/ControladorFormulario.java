package co.poli.edu.cguzman.controlador;

import java.sql.SQLException;

import co.poli.edu.cguzman.modelo.Cliente;
import co.poli.edu.cguzman.modelo.Departamento;
import co.poli.edu.cguzman.modelo.Empleado;
import co.poli.edu.cguzman.modelo.FactoryProductElectric;
import co.poli.edu.cguzman.modelo.FactoryProductFood;
import co.poli.edu.cguzman.services.ClienteImplementacionDAO;
import co.poli.edu.cguzman.services.GenericDAO;

import co.poli.edu.cguzman.modelo.FactoryProduct;
import co.poli.edu.cguzman.modelo.Producto;
import co.poli.edu.cguzman.modelo.ProductoAlimento;
import co.poli.edu.cguzman.modelo.ProductoElectrico;
import co.poli.edu.cguzman.services.ProductoDAO;
import co.poli.edu.cguzman.services.ProductoImplementacionDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controlador para el formulario de cliente y productos.
 */
public class ControladorFormulario {

	@FXML
	private TextArea txtarea_composite;

	@FXML
	private Label lbl_idcliente, lbl_nombrecliente, lbl_idproducto, lbl_tipoproducto, lbl_descripcionproducto,
			lbl_calvol;

	@FXML
	private ComboBox<String> comboTipoProducto;

	@FXML
	private VBox vboxAlimento, vboxElectrico;

	@FXML
	private Button btn_guardar, btn_consultar, btn_eliminar, btn_actualizar, btn_guardar2, btn_consultar2,
			btn_eliminar2, btn_actualizar2, btn_clonarProducto, btn_cargar;

	// Se usa la interfaz GenericDAO, para aplicar polimorfismo.
	@FXML
	private TextField txt_id, txt_nombres, txt_idproducto, txt_nombreproducto, txtCalorias, txtVoltaje;

	// Se usa la interfaz GenericDAO, para aplicar polimorfismo.
	private GenericDAO<Cliente, String> clienteDAO = new ClienteImplementacionDAO();
	private ProductoDAO productoDAO = new ProductoImplementacionDAO();
//	private ProductFactory productFactory = new FoodProductFactory(500);

	/**
	 * Método que inicializa la interfaz de usuario con los componentes necesarios.
	 */
	@FXML
	private void initialize() {

		comboTipoProducto.getItems().addAll("Alimento", "Electrico"); // Agregar opciones al ComboBox

		txt_idproducto.setVisible(true);
		txt_nombreproducto.setVisible(true);
		vboxAlimento.setVisible(false);
		vboxElectrico.setVisible(false);

		// Configurar evento para mostrar/ocultar campos según el tipo de producto
		// seleccionado
		comboTipoProducto.setOnAction(event -> actualizarCampos());
	}

	/**
	 * Método que se ejecuta al cargar el formulario.
	 */

	@FXML
	private void actualizarCampos() {
		String tipo = comboTipoProducto.getValue();

		if ("Alimento".equals(tipo)) {
			vboxAlimento.setVisible(true);
			vboxElectrico.setVisible(false);
		} else if ("Electrico".equals(tipo)) {
			vboxAlimento.setVisible(false);
			vboxElectrico.setVisible(true);
		}
	}

	@FXML
	private void crearCliente(ActionEvent event) {
		String id = txt_id.getText();
		String nombre = txt_nombres.getText();

		if (id.isEmpty() || nombre.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID y Nombre.");
			return;
		}

		try {
			Cliente clienteExistente = clienteDAO.read(id); // Verifica si el cliente ya existe
			if (clienteExistente != null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "El cliente con ID " + id + " ya existe.");
				return;
			}

			Cliente cliente = new Cliente(id, nombre);
			clienteDAO.create(cliente);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Cliente Registrado",
					"Cliente creado con ID: " + id + " y Nombre: " + nombre);
			limpiarCampos();
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al crear el cliente", e.getMessage());
		}
	}

	@FXML
	public void clonarProducto() throws Exception {
		String idOriginal = txt_idproducto.getText();

		if (idOriginal.isEmpty()) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar el ID del producto a clonar.");
			return;
		}

		try {
			// Buscar el producto original
			Producto productoOriginal = productoDAO.read(idOriginal);
			if (productoOriginal == null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "No se encontró un producto con ID: " + idOriginal);
				return;
			}

			// Obtener el último ID de la base de datos y calcular el nuevo ID
			int nuevoId = productoDAO.obtenerUltimoID() + 1;

			// Clonar el producto usando el método clone()
			Producto productoClonado = productoOriginal.clone();
			if (productoClonado == null) {
				mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo clonar el producto.");
				return;
			}

			productoClonado.setId(String.valueOf(nuevoId)); // Asignar el nuevo ID

			// Guardar el producto clonado en la base de datos
			productoDAO.create(productoClonado);

			mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Clonado",
					"El producto fue clonado con éxito. Nuevo ID: " + nuevoId);
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al clonar el producto", e.getMessage());
		} catch (Exception e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error inesperado", e.getMessage());
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
			Cliente clienteExistente = clienteDAO.read(id); // Verifica si existe el cliente
			if (clienteExistente == null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "No se encontró un cliente con ID: " + id);
				return;
			}

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
		String tipoProducto = comboTipoProducto.getValue();

		if (id.isEmpty() || descripcion.isEmpty() || tipoProducto == null) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar ID, descripción y seleccionar un tipo.");
			return;
		}

		Producto producto = null;

		try {
			if ("Alimento".equals(tipoProducto)) {
				String caloriasStr = txtCalorias.getText();
				if (caloriasStr.isEmpty()) {
					mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar las calorías del producto.");
					return;
				}
				int calorias = Integer.parseInt(caloriasStr);
				FactoryProduct factory = new FactoryProductFood(calorias);
				producto = factory.createProducto(id, descripcion);
			} else if ("Electrico".equals(tipoProducto)) {
				String voltajeStr = txtVoltaje.getText();
				if (voltajeStr.isEmpty()) {
					mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar el voltaje del producto.");
					return;
				}
				int voltaje = Integer.parseInt(voltajeStr);
				FactoryProduct factory = new FactoryProductElectric(voltaje);
				producto = factory.createProducto(id, descripcion);
			}

			if (producto != null) {
				productoDAO.create(producto);
				mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Registrado",
						"Producto creado con ID: " + id + " y Nombre: " + descripcion);
				limpiarCampos();
			}
		} catch (NumberFormatException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
					"Ingrese valores numéricos válidos en calorías o voltaje.");
		} catch (SQLException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error al crear el producto", e.getMessage());
		}
	}

	@FXML
	private void actualizarProducto(ActionEvent event) {
		String id = txt_idproducto.getText();
		String descripcion = txt_nombreproducto.getText();
		String tipoProducto = comboTipoProducto.getValue();

		// Validaciones iniciales
		if (id.isEmpty() || descripcion.isEmpty() || tipoProducto == null) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error",
					"Debe ingresar ID, descripción y seleccionar un tipo de producto.");
			return;
		}

		try {
			// Verificar si el producto existe en la base de datos
			Producto productoExistente = productoDAO.read(id);
			if (productoExistente == null) {
				mostrarAlerta(Alert.AlertType.WARNING, "Error", "No se encontró un producto con ID: " + id);
				return;
			}

			Producto productoActualizado = null;

			// Crear una nueva instancia según el tipo seleccionado
			if (tipoProducto.equals("Alimento")) {
				String caloriasStr = txtCalorias.getText();
				if (caloriasStr.isEmpty()) {
					mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar las calorías del producto.");
					return;
				}
				int calorias = Integer.parseInt(caloriasStr);
				productoActualizado = new ProductoAlimento(id, descripcion, calorias);
			} else if (tipoProducto.equals("Electrico")) {
				String voltajeStr = txtVoltaje.getText();
				if (voltajeStr.isEmpty()) {
					mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe ingresar el voltaje del producto.");
					return;
				}
				int voltaje = Integer.parseInt(voltajeStr);
				productoActualizado = new ProductoElectrico(id, descripcion, voltaje);
			}

			// Verificar que el producto actualizado no sea nulo
			if (productoActualizado == null) {
				mostrarAlerta(Alert.AlertType.ERROR, "Error", "El tipo de producto no es válido.");
				return;
			}

			// Llamar al DAO para actualizar en la base de datos
			productoDAO.update(productoActualizado);
			mostrarAlerta(Alert.AlertType.INFORMATION, "Producto Actualizado",
					"Producto con ID: " + id + " ha sido actualizado correctamente.");
			limpiarCampos();
		} catch (NumberFormatException e) {
			mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
					"Ingrese valores numéricos válidos en calorías o voltaje.");
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

	@FXML
	private void inicializarEstructura() {

		// Crear rector
		Empleado rector = new Empleado("Dr. Juan Pérez", "Rector");

		// Crear facultades
		Departamento facultadIngenieria = new Departamento("Facultad de Ingeniería, Diseño e Innovación");
		Departamento facultadSociedad = new Departamento("Facultad de Sociedad, Cultura y Creatividad");
		Departamento facultadNegocios = new Departamento("Facultad de Negocios, Gestión y Sostenibilidad");

		// Crear coordinadores de facultad
		Empleado coordIngenieria = new Empleado("Ing. María Fernández", "Coordinadora de Ingeniería");
		Empleado coordSociedad = new Empleado("Lic. Carlos Ramírez", "Coordinador de Sociedad y Cultura");
		Empleado coordNegocios = new Empleado("Eco. Laura Gómez", "Coordinadora de Negocios y Gestión");

		// Crear profesores
		Empleado profIngenieria = new Empleado("Dr. Luis Torres", "Profesor de Ingeniería");
		Empleado profSociedad = new Empleado("Mtro. Andrés Morales", "Profesor de Cultura y Sociedad");
		Empleado profNegocios = new Empleado("Lic. Sofía Herrera", "Profesor de Negocios y Gestión");

		// Agregar empleados a cada facultad
		facultadIngenieria.agregarUnidad(coordIngenieria);
		facultadIngenieria.agregarUnidad(profIngenieria);

		facultadSociedad.agregarUnidad(coordSociedad);
		facultadSociedad.agregarUnidad(profSociedad);

		facultadNegocios.agregarUnidad(coordNegocios);
		facultadNegocios.agregarUnidad(profNegocios);

		// Crear rectoría y agregar las facultades
		Departamento rectoria = new Departamento("Rectoría");
		rectoria.agregarUnidad(rector);
		rectoria.agregarUnidad(facultadIngenieria);
		rectoria.agregarUnidad(facultadSociedad);
		rectoria.agregarUnidad(facultadNegocios);

		// Mostrar en el TextArea
		StringBuilder builder = new StringBuilder();
		rectoria.mostrarInfo(builder);
		txtarea_composite.setText(builder.toString());

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
