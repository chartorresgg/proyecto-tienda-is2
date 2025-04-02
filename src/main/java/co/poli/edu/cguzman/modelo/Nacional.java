package co.poli.edu.cguzman.modelo;

public class Nacional implements Envio {

	@Override
	public String procesarEnvio() {
		return "El envío será procesado dentro del territorio nacional.";
	}

}
