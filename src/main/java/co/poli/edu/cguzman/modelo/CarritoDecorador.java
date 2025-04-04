package co.poli.edu.cguzman.modelo;

/**
 * Clase abstracta que representa un decorador para el carrito de compras.
 * Implementa la interfaz CarritoCompras.
 */
public abstract class CarritoDecorador implements CarritoCompras {
	
	protected CarritoCompras carritoDecorador;
	
	public CarritoDecorador(CarritoCompras carrito) {
		this.carritoDecorador = carrito;
	}
	
	@Override
	public String obtenerDescripcion() {
		return carritoDecorador.obtenerDescripcion();
	}
	
	@Override
	public double obtenerTotalCompra() {
		return carritoDecorador.obtenerTotalCompra();
	}

}