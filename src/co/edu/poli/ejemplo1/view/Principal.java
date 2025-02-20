package co.edu.poli.ejemplo1.view;

import java.io.IOException;

import co.edu.poli.ejemplo1.controller.ClienteController;
import co.edu.poli.ejemplo1.controller.ProductoController;
import co.edu.poli.ejemplo1.services.GestionConexion;

public class Principal {

	// Variable que almacena un identificador de cliente (valor por defecto "5")
	public static String txtid = "5";

	// Variable que almacena el nombre del cliente (valor por defecto "5")
	public static String txtname = "5";

	/**
	 * Método principal que ejecuta la aplicación. Crea una instancia del
	 * controlador de clientes y llama al método Actioncrear() para registrar un
	 * nuevo cliente en la base de datos.
	 *
	 * @param args Argumentos de línea de comandos (no utilizados en este caso).
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Creación del controlador de cliente
		ClienteController cc = new ClienteController();
		ProductoController pc = new ProductoController();

		// Llamada al método para crear un cliente y mostrar el mensaje de resultado
		System.out.println(cc.actionCrear());
		System.out.println(pc.crearProducto());

		// Mostrar el mensaje de error de la conexión
		System.out.println(GestionConexion.getMensajeError());
	}
}