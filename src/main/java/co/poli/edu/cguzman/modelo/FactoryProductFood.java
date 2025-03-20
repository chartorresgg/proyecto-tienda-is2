package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa la fábrica concreta de productos de tipo comida.
 * Implementa la interfaz ProductFactory y se encarga de instanciar objetos de
 * tipo ProductoAlimento.
 */
public class FactoryProductFood implements FactoryProduct {

	// Atributo que almacena la cantidad de calorías del producto alimenticio.
	private int calorias;

	/**
	 * Constructor de la clase FoodProductFactory.
	 * 
	 * @param calorias Cantidad de calorías que tendrá el producto creado.
	 */
	public FactoryProductFood(int calorias) {
		this.calorias = calorias;
	}

	/**
	 * Método que crea un producto de tipo comida.
	 * 
	 * @param id          Identificador único del producto.
	 * @param descripcion Breve descripción del producto.
	 * @return Un objeto de tipo ProductoAlimento con las características
	 *         especificadas.
	 */
	@Override
	public Producto createProducto(String id, String descripcion) {
		return new ProductoAlimento(id, descripcion, calorias);
	}
}