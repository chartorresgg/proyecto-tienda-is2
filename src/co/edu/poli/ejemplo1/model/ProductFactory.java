package co.edu.poli.ejemplo1.model;

/**
 * Interfaz Factory para la creación de productos. Define un método abstracto
 * para la creación de objetos Producto.
 */
public interface ProductFactory {

	/**
	 * Método que crea un producto.
	 * 
	 * @param id          Identificador único del producto.
	 * @param descripcion Breve descripción del producto.
	 * @return Un objeto de tipo Producto.
	 */
	Producto createProducto(String id, String descripcion);
}