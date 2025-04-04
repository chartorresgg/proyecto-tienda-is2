package co.poli.edu.cguzman.modelo;

public class CargaPeligrosa extends Mercancia {

	public CargaPeligrosa(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando carga peligrosa. " + envio.procesarEnvio();
	}

}
