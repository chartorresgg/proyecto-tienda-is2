package co.poli.edu.cguzman.modelo;

/**
 * Clase abstracta Mercancia que representa un tipo de mercancia a enviar.
 * Contiene una referencia a un objeto de tipo Envio.
 */
public abstract class Mercancia {

	protected Envio envio;
	
	public Mercancia(Envio envio) {
		this.envio = envio;
	}
	
	public abstract String enviar();
}
