package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa un Producto Eléctrico en la aplicación. Hereda de
 * Producto y añade el atributo voltaje de entrada.
 */
public class ProductoElectrico extends Producto {

	private double voltajeEntrada; // Voltaje de entrada del producto.

	/**
	 * Constructor de la clase ProductoElectrico.
	 * 
	 * @param id             Identificador del producto.
	 * @param descripcion    Descripción del producto.
	 * @param voltajeEntrada Voltaje de entrada del producto.
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
	 * Representación en cadena del objeto ProductoElectrico.
	 * 
	 * @return Cadena con el id, descripción y voltaje de entrada.
	 */
	@Override
	public String toString() {
		return "ProductoElectrico{" + "id='" + getId() + "', descripcion='" + getDescripcion() + "', voltajeEntrada="
				+ voltajeEntrada + "}";
	}

	@Override
	public Producto clone() {
		return new ProductoElectrico(getId(), getDescripcion(), getVoltajeEntrada());
	}

	/**
	 * Implementación del método obtenerTipo para identificar el tipo de producto.
	 * 
	 * @return "Eléctrico".
	 */
	@Override
	public String obtenerTipo() {
		return "Tipo de producto: Eléctrico";
	}
}