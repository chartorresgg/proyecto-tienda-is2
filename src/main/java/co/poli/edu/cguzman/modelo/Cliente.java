package co.poli.edu.cguzman.modelo;

/**
 * SRP: Clase que representa al Cliente, el cual puede realizar Pedidos.
 */
public class Cliente {

	public void setId(String id) {
		this.id = id;
	}

	private String id;
	private String nombre;

	// Constructor de la clase Cliente.
	public Cliente(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// Métodos Getters y Setters

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en forma de cadena del objeto Cliente. Incluye el
	 * ID y el nombre del cliente en un formato legible.
	 *
	 * @return Una cadena que representa al cliente en el formato:
	 *         Cliente{ID='valor_id', Nombre='valor_nombre'}
	 */
	@Override
	public String toString() {
		return "Cliente{" + "ID ='" + id + "', Nombre ='" + nombre + "'}";
	}
}