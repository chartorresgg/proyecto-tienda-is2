package co.edu.poli.ejemplo1.view;

import java.io.IOException;
import java.util.Scanner;
import co.edu.poli.ejemplo1.controller.ClienteController;
import co.edu.poli.ejemplo1.controller.ProductoController;
import co.edu.poli.ejemplo1.model.ElectricProductFactory;
import co.edu.poli.ejemplo1.model.FoodProductFactory;

/**
 * Clase que inicializa la aplicación.
 */
public class AppInitializer {

    public void initialize() throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Crear cliente
        ClienteController clienteController = new ClienteController();
        String mensaje1 = clienteController.crearCliente();
        ConsolePrinter.print(mensaje1);
        
        // Solicitar tipo de producto
        System.out.println("Seleccione el tipo de producto (1: Eléctrico, 2: Alimento): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        ProductoController productoController;
        if (opcion == 1) {
            System.out.println("Ingrese el voltaje del producto eléctrico: ");
            int voltaje = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            productoController = new ProductoController(new ElectricProductFactory(voltaje));
        } else {
            System.out.println("Ingrese las calorías del producto alimenticio: ");
            int calorias = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            productoController = new ProductoController(new FoodProductFactory(calorias));
        }
        
        // Solicitar detalles del producto
        System.out.println("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        
        // Crear producto
        String mensaje2 = productoController.createProduct(codigo, nombre);
        ConsolePrinter.print(mensaje2);
        
        scanner.close();
    }
}
