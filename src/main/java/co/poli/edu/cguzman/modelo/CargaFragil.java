package co.poli.edu.cguzman.modelo;

public class CargaFragil extends Mercancia {

	public CargaFragil(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando carga fragil. " + envio.procesarEnvio();
	}

}
