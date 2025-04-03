package co.poli.edu.cguzman.modelo;

public class PuntosRecompensa extends CarritoDecorador {
	
	private int puntos;
	
	public PuntosRecompensa(CarritoCompras carrito, int puntos) {
		super(carrito);
		this.puntos = puntos;
	}
	
	public String obtenerDescripcion() {
		return carritoDecorador.obtenerDescripcion() + ", Puntos de recompensa: " + puntos;
	}
	
	public double obtenerTotalCompra() {
		return carritoDecorador.obtenerTotalCompra();
	}
	
	public int getPuntos() {
		return puntos;
	}

}