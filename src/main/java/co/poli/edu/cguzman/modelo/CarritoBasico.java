package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa un carrito de compras básico. Implementa la interfaz
 * CarritoCompras.
 */
public class CarritoBasico implements CarritoCompras {

	private double costoBase; // Costo base del carrito de compras

	public CarritoBasico(double costoBase) {
		this.costoBase = costoBase;
	}

	/**
	 * Método que obtiene la descripción del carrito de compras.
	 * 
	 * @return Descripción del carrito de compras.
	 */
	public String obtenerDescripcion() {
		return "Carrito de compras básico";
	}

	/**
	 * Método que obtiene el costo total de la compra.
	 * 
	 * @return Costo total de la compra.
	 */
	public double obtenerTotalCompra() {
		return costoBase;
	}

}