package co.poli.edu.cguzman.modelo;

public class Descuento extends CarritoDecorador {

	private double montoDescuento;

	public Descuento(CarritoCompras carrito, double montoDescuento) {
		super(carrito);
		this.montoDescuento = montoDescuento;
	}

	@Override
	public String obtenerDescripcion() {
		return super.obtenerDescripcion() + " con descuento de $" + montoDescuento;
	}

	@Override
	public double obtenerTotalCompra() {
		double totalCompra = super.obtenerTotalCompra();
		return Math.max(totalCompra - montoDescuento, 0); // Evita que el total sea negativo
	}
}