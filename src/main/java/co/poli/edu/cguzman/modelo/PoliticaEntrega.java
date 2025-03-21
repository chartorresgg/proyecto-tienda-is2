package co.poli.edu.cguzman.modelo;

/**
 * Clase PoliticaEntrega.
 * 
 * Esta clase contiene los atributos y métodos de una política de entrega.
 * 
 * @version 1.0
 */
public class PoliticaEntrega {

	private String tiempoEntrega;
	private String modoEntrega;
	private String costoEnvio;

	/**
	 * Constructor de la clase PoliticaEntrega.
	 * 
	 * @param tiempoEntrega Tiempo de entrega de la política.
	 * @param modoEntrega   Modo de entrega de la política.
	 * @param costoEnvio    Costo de envío de la política.
	 */
	public PoliticaEntrega(String tiempoEntrega, String modoEntrega, String costoEnvio) {
		super();
		this.tiempoEntrega = tiempoEntrega;
		this.modoEntrega = modoEntrega;
		this.costoEnvio = costoEnvio;
	}

	// Getters y Setters

	public String getTiempoEntrega() {
		return tiempoEntrega;
	}

	public String getModoEntrega() {
		return modoEntrega;
	}

	public String getCostoEnvio() {
		return costoEnvio;
	}

	@Override
	public String toString() {
		return "PoliticaEntrega [tiempoEntrega=" + tiempoEntrega + ", modoEntrega=" + modoEntrega + ", costoEnvio="
				+ costoEnvio + "]";
	}
	
}
