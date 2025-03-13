package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa la fábrica concreta de productos de tipo eléctrico.
 * Implementa la interfaz ProductFactory y se encarga de instanciar objetos de
 * tipo ProductoElectrico.
 */
public class ElectricProductFactory implements ProductFactory {

	// Atributo que almacena el voltaje de entrada del producto eléctrico.
	private double voltajeEntrada;

	/**
	 * Constructor de la clase ElectricProductFactory.
	 * 
	 * @param voltajeEntrada Voltaje requerido para el funcionamiento del producto
	 *                       eléctrico.
	 */
	public ElectricProductFactory(double voltajeEntrada) {
		this.voltajeEntrada = voltajeEntrada;
	}

	/**
	 * Método que crea un producto eléctrico.
	 * 
	 * @param id          Identificador único del producto.
	 * @param descripcion Breve descripción del producto.
	 * @return Un objeto de tipo ProductoElectrico con las características
	 *         especificadas.
	 */
	@Override
	public Producto createProducto(String id, String descripcion) {
		return new ProductoElectrico(id, descripcion, voltajeEntrada);
	}
}
