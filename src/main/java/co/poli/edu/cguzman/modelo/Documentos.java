package co.poli.edu.cguzman.modelo;

public class Documentos extends Mercancia {

	public Documentos(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando documentos. " + envio.procesarEnvio();
	}

}
