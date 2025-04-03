package co.poli.edu.cguzman.modelo;

public class CarritoBasico implements CarritoCompras{
	
	private double costoBase;
	
	public CarritoBasico(double costoBase) {
		this.costoBase = costoBase;
	}
	
	public String obtenerDescripcion() {
		return "Carrito de compras basico";
	}
	
	public double obtenerTotalCompra() {
		return costoBase;
	}

}