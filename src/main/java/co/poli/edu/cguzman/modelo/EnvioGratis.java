package co.poli.edu.cguzman.modelo;

public class EnvioGratis extends CarritoDecorador {
	
	public EnvioGratis(CarritoCompras carrito) {
		super(carrito);
	}
	
	@Override
	public String obtenerDescripcion() {
		return carritoDecorador.obtenerDescripcion() + ", Envio gratis";
	}
	
	@Override
	public double obtenerTotalCompra() {
		return carritoDecorador.obtenerTotalCompra();
	}

}