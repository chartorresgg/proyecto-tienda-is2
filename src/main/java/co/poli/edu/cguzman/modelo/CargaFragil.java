package co.poli.edu.cguzman.modelo;

/**
 * Clase que representa una carga frágil.
 * Extiende la clase Mercancia y utiliza el patrón Decorador.
 */
public class CargaFragil extends Mercancia {

	public CargaFragil(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando carga fragil. " + envio.procesarEnvio();
	}

}
