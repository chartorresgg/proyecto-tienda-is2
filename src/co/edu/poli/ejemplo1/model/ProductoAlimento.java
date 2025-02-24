package co.edu.poli.ejemplo1.model;

/**
 * Clase que representa un Producto de Aporte Calórico en la aplicación.
 */
public class ProductoAlimento extends Producto {
	
	private int calorias;

	/**
	 * Constructor de la clase ProductoAlimento.
	 * 
	 * @param id
	 * @param descripcion
	 * @param calorias
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
	 * Retorna una representación en forma de cadena del objeto ProductoAlimento.
	 * 
	 * @return Una cadena que contiene el id, la descripción y las calorías del
	 *         producto.
	 */
	@Override
	public String toString() {
		return "ProductoAlimento{" + "id='" + getId() + "', descripcion='" + getDescripcion() + "', calorias="
				+ calorias + "}";
	}
}