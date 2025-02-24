package co.edu.poli.ejemplo1.view;

import java.io.IOException;
import co.edu.poli.ejemplo1.controller.ClienteController;
import co.edu.poli.ejemplo1.controller.ProductoController;

/**
 * Clase que inicializa la aplicación.
 */
public class AppInitializer {

	public void initialize() throws IOException {
		ClienteController clienteController = new ClienteController();
		ProductoController productoController = new ProductoController();

		String mensaje = clienteController.crearCliente();
		String msj = productoController.crearProducto();

		ConsolePrinter.print(mensaje);
		ConsolePrinter.print(msj);
	}
}