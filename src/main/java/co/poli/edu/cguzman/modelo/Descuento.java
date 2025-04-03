package co.poli.edu.cguzman.modelo;

public class Descuento extends CarritoDecorador {
	
	private double porcentajeDescuento;
	
	public Descuento(CarritoCompras carrito, double porcentajeDescuento) {
		super(carrito);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	@Override
	public String obtenerDescripcion() {
		return carritoDecorador.obtenerDescripcion() + " con descuento del " + porcentajeDescuento + "%";
	}
	
	@Override
	public double obtenerTotalCompra() {
		double totalCompra = carritoDecorador.obtenerTotalCompra();
		return totalCompra - (totalCompra * (porcentajeDescuento / 100));
	}

}