package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa un Producto de Aporte Calórico en la aplicación. Hereda
 * de la clase Producto e incorpora un atributo adicional: calorías.
 */
public class ProductoAlimento extends Producto implements Prototype {

	private int calorias; // Cantidad de calorías del producto.

	/**
	 * Constructor de la clase ProductoAlimento.
	 * 
	 * @param id          Identificador del producto.
	 * @param descripcion Descripción del producto.
	 * @param calorias    Cantidad de calorías.
	 */
	public ProductoAlimento(String id, String descripcion, int calorias) {
		super(id, descripcion);
		this.calorias = calorias;
	}

	// Métodos Getters y Setters.
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	/**
	 * Representación en cadena del objeto ProductoAlimento.
	 * 
	 * @return Cadena con el id, descripción y calorías del producto.
	 */
	@Override
	public String toString() {
		return "ProductoAlimento{" + "id='" + getId() + "', descripcion='" + getDescripcion() + "', calorias="
				+ calorias + "}";
	}

	/**
	 * Implementación del método obtenerTipo para identificar el tipo de producto.
	 * 
	 * @return "Alimento".
	 */
	@Override
	public String obtenerTipo() {
		return "Tipo de producto: Alimento";
	}

	@Override
	public Producto clone() {
		return new ProductoAlimento(getId(), getDescripcion(), getCalorias());
	}

}