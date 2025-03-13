package co.poli.edu.cguzman.vista;

import java.io.IOException;
import java.util.Scanner;
import co.poli.edu.cguzman.controlador.ClienteController;
import co.poli.edu.cguzman.controlador.ProductoController;
import co.poli.edu.cguzman.modelo.ElectricProductFactory;
import co.poli.edu.cguzman.modelo.FoodProductFactory;

/**
 * Clase principal que permite la interacción con el usuario para la creación de
 * un cliente y un producto. Los datos creados son almacenados en una base de
 * datos.
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		ClienteController clienteController = new ClienteController();
		ProductoController productoController = null;

		while (true) {
			System.out.println("\n--- MENÚ PRINCIPAL ---");
			System.out.println("1. Crear Cliente");
			System.out.println("2. Crear Producto");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1:
				// Solicitar datos del cliente
				System.out.print("Ingrese el ID del cliente: ");
				String idCliente = scanner.nextLine();

				System.out.print("Ingrese el nombre del cliente: ");
				String nombreCliente = scanner.nextLine();

				// Crear cliente
				System.out.println(clienteController.createClient(idCliente, nombreCliente));
				break;

			case 2:
				// Solicitar tipo de producto
				System.out.println("Seleccione el tipo de producto (1: Eléctrico, 2: Alimento): ");
				int tipoProducto = scanner.nextInt();
				scanner.nextLine(); // Limpiar buffer

				if (tipoProducto == 1) {
					System.out.print("Ingrese el voltaje del producto eléctrico: ");
					int voltaje = scanner.nextInt();
					scanner.nextLine(); // Limpiar buffer
					productoController = new ProductoController(new ElectricProductFactory(voltaje));
				} else {
					System.out.print("Ingrese las calorías del producto alimenticio: ");
					int calorias = scanner.nextInt();
					scanner.nextLine(); // Limpiar buffer
					productoController = new ProductoController(new FoodProductFactory(calorias));
				}

				// Solicitar detalles del producto
				System.out.print("Ingrese el código del producto: ");
				String codigoProducto = scanner.nextLine();

				System.out.print("Ingrese el nombre del producto: ");
				String nombreProducto = scanner.nextLine();

				// Crear producto
				System.out.println(productoController.createProduct(codigoProducto, nombreProducto));
				break;

			case 3:
				System.out.println("Saliendo del programa...");
				scanner.close();
				return;

			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
		}
	}
}
