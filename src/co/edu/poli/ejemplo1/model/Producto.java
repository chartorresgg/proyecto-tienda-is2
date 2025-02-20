package co.edu.poli.ejemplo1.model;

/**
 * Clase que representa un Producto en la aplicación.
 */
public class Producto {
	private String id;
	private String descripcion;

	/**
	 * Constructor de la clase Producto.
	 * 
	 * @param id
	 * @param descripcion
	 */
	public Producto(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	// Métodos Getters y Setters.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Retorna una representación en forma de cadena del objeto Producto.
	 * 
	 * @return Una cadena que contiene el id y la descripción del producto.
	 */
	@Override
	public String toString() {
		return "Producto{" + "id='" + id + "', descripcion='" + descripcion + "'}";
	}
}