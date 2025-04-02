package co.poli.edu.cguzman.modelo;

public class CargaNormal extends Mercancia {

	public CargaNormal(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando carga normal. " + envio.procesarEnvio();
	}

}
