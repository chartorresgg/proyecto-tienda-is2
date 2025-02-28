package co.edu.poli.ejemplo1.view;

import java.io.IOException;
import co.edu.poli.ejemplo1.controller.ClienteController;
import co.edu.poli.ejemplo1.controller.ProductoController;
import co.edu.poli.ejemplo1.model.ElectricProductFactory;

/**
 * Clase que inicializa la aplicación.
 */
public class AppInitializer {

	public void initialize() throws IOException {
		
		ClienteController clienteController = new ClienteController();
		ProductoController productoController = new ProductoController(new ElectricProductFactory(220)); // Se crea un objeto de tipo ElectricProductFactory con un voltaje de 220V.

		String mensaje1 = clienteController.crearCliente();
		ConsolePrinter.print(mensaje1);
		
		String mensaje2 = productoController.createProduct("PE003", "Martillo eléctrico");		
		ConsolePrinter.print(mensaje2);

	}
}