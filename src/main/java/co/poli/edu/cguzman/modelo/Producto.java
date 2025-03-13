package co.poli.edu.cguzman.modelo;

/**
 * Clase abstracta que representa un Producto en la aplicación. Define atributos
 * y métodos básicos que deben implementar las subclases.
 */
public abstract class Producto implements Prototype {
	private String id; // Identificador único del producto.
	private String descripcion; // Descripción del producto.

	/**
	 * Constructor de la clase Producto.
	 * 
	 * @param id          Identificador del producto.
	 * @param descripcion Descripción del producto.
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
	 * Método abstracto que debe ser implementado por las subclases.
	 * 
	 * @return Tipo del producto.
	 */
	public abstract String obtenerTipo();

	@Override
	public abstract Producto clone();

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