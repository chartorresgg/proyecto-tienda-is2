package co.poli.edu.cguzman.modelo;

public abstract class Mercancia {

	protected Envio envio;
	
	public Mercancia(Envio envio) {
		this.envio = envio;
	}
	
	public abstract String enviar();
}
