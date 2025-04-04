package co.poli.edu.cguzman.modelo;

public class Express implements Envio {

	@Override
	public String procesarEnvio() {
		return "El envío será procesado de manera Express.";
	}

}
