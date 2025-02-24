package co.edu.poli.ejemplo1.model;

/**
 * Clase que representa un Producto Eléctrico en la aplicación.
 */
public class ProductoElectrico extends Producto {

	private double voltajeEntrada;

	/**
	 * Constructor de la clase ProductoElectrico.
	 * 
	 * @param id
	 * @param descripcion
	 * @param voltajeEntrada
	 */
	public ProductoElectrico(String id, String descripcion, double voltajeEntrada) {
		super(id, descripcion);
		this.voltajeEntrada = voltajeEntrada;
	}

	// Métodos Getters y Setters.
	public double getVoltajeEntrada() {
		return voltajeEntrada;
	}

	public void setVoltajeEntrada(double voltajeEntrada) {
		this.voltajeEntrada = voltajeEntrada;
	}

	/**
	 * Retorna una representación en forma de cadena del objeto ProductoElectrico.
	 * 
	 * @return Una cadena que contiene el id, la descripción y el voltaje de entrada
	 *         del producto.
	 */
	@Override
	public String toString() {
		return "ProductoElectrico{" + "id='" + getId() + "', descripcion='" + getDescripcion() + "', voltajeEntrada="
				+ voltajeEntrada + "}";
	}
}