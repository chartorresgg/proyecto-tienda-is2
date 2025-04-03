package co.poli.edu.cguzman.modelo;

/**
 * Clase que extiende de Mercancia y define el método enviar para envíos de
 * carga normal.
 * 
 * @version 1.0
 */
public class CargaNormal extends Mercancia {

	public CargaNormal(Envio envio) {
		super(envio);
	}

	@Override
	public String enviar() {
		return "Enviando carga normal. " + envio.procesarEnvio();
	}

}
