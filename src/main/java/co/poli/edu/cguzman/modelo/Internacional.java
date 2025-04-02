package co.poli.edu.cguzman.modelo;

public class Internacional implements Envio {

	@Override
	public String procesarEnvio() {
		return "El envío será procesado a nivel internacional.";
	}

}
