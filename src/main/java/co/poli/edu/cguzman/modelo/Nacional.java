package co.poli.edu.cguzman.modelo;

/**
 * Clase que implementa la interfaz Envio y define el método procesarEnvio para
 * envíos nacionales.
 * 
 * @version 1.0
 */
public class Nacional implements Envio {

	@Override
	public String procesarEnvio() {
		return "El envío será procesado dentro del territorio nacional.";
	}

}
