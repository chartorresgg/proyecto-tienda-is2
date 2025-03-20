package co.poli.edu.cguzman.modelo;

/**
 * Interfaz Factory para la creación de productos. Define un método abstracto
 * para la creación de ProductoS.
 */
public interface FactoryProduct {

	/**
	 * Método abstracto para la creación de un Producto.
	 * 
	 * @param id          Identificador del producto.
	 * @param descripcion Descripción del producto.
	 * @return Producto creado.
	 */
	Producto createProducto(String id, String descripcion);
}