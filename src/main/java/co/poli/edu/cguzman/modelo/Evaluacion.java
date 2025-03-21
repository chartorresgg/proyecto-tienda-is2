package co.poli.edu.cguzman.modelo;

/**
 * Clase Evaluacion.
 * 
 * Esta clase contiene los atributos y métodos de una evaluación.
 * 
 * @version 1.0
 */
public class Evaluacion {

	private String nivelCalidad;
	private double puntaje;
	private String observaciones;

	/**
	 * Constructor de la clase Evaluacion.
	 * 
	 * @param nivelCalidad  Nivel de calidad de la evaluación.
	 * @param puntaje       Puntaje de la evaluación.
	 * @param observaciones Observaciones de la evaluación.
	 */
	public Evaluacion(String nivelCalidad, double puntaje, String observaciones) {
		super();
		this.nivelCalidad = nivelCalidad;
		this.puntaje = puntaje;
		this.observaciones = observaciones;
	}

	// Getters y Setters

	public String getNivelCalidad() {
		return nivelCalidad;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public String getObservaciones() {
		return observaciones;
	}

	@Override
	public String toString() {
		return "Evaluacion [nivelCalidad=" + nivelCalidad + ", puntaje=" + puntaje + ", observaciones=" + observaciones
				+ "]";
	}

}