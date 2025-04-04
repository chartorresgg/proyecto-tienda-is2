package co.poli.edu.cguzman.modelo;

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