package co.poli.edu.cguzman.modelo;

/**
 * Clase que implementa la interfaz Envio y define el método procesarEnvio para
 * envíos internacionales.
 * 
 * @version 1.0
 */
public class Internacional implements Envio {

	@Override
	public String procesarEnvio() {
		return "El envío será procesado a nivel internacional.";
	}

}
