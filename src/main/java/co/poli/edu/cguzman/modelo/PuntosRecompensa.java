package co.poli.edu.cguzman.modelo;

public class PuntosRecompensa extends CarritoDecorador {
	
	private int puntos;
	
	public PuntosRecompensa(CarritoCompras carrito, int puntos) {
		super(carrito);
		this.puntos = puntos;
	}
	
	public String obtenerDescripcion() {
		return super.obtenerDescripcion() + ", con " + puntos + " puntos de recompensa";
	}
	
	public double obtenerTotalCompra() {
		return super.obtenerTotalCompra();
	}
	
}