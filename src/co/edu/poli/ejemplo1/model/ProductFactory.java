package co.edu.poli.ejemplo1.model;

/**
 * Interfaz Factory para la creación de productos. Define un método abstracto
 * para la creación de ProductoS.
 */
public interface ProductFactory {

	/**
	 * Método abstracto para la creación de un Producto.
	 * 
	 * @param id          Identificador del producto.
	 * @param descripcion Descripción del producto.
	 * @return Producto creado.
	 */
	Producto createProducto(String id, String descripcion);
}