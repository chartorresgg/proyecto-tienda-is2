package co.edu.poli.ejemplo1.view;

import co.edu.poli.ejemplo1.controller.ClienteController;
import co.edu.poli.ejemplo1.controller.ProductoController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Clase principal que ejecuta la aplicación. Se encarga de crear un cliente a
 * través del controlador y mostrar un mensaje en la consola.
 */
public class Main {

	/**
	 * Método principal que inicia la ejecución del programa. Crea una instancia de
	 * ClienteController, llama al método Actioncrear() para crear un cliente y
	 * muestra el mensaje en la consola.
	 * 
	 * @param args Argumentos de la línea de comandos (no utilizados en este
	 *             programa).
	 */
	public static void main(String[] args) {

		ClienteController clienteController = new ClienteController();
		ProductoController productoController = new ProductoController();

		String mensaje = clienteController.Actioncrear();
		String msj = productoController.crearProducto();

		System.out.println(mensaje);
		System.out.println(msj);

	}
}
