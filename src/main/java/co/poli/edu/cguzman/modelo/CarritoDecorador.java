package co.poli.edu.cguzman.modelo;

public abstract class CarritoDecorador implements CarritoCompras {
	
	protected CarritoCompras carritoDecorador;
	
	public CarritoDecorador(CarritoCompras carrito) {
		this.carritoDecorador = carrito;
	}
	
	public String obtenerDescripcion() {
		return carritoDecorador.obtenerDescripcion();
	}
	
	public double obtenerTotalCompra() {
		return carritoDecorador.obtenerTotalCompra();
	}

}