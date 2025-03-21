package co.poli.edu.cguzman.modelo;

/**
 * Clase Certificacion.
 * 
 * Esta clase contiene los atributos y métodos de una certificación.
 * 
 * @version 1.0
 */
public class Certificacion {

	private String tipoCertificacion;
	private String entidadCertificadora;
	private String idCertificacion;

	/**
	 * Constructor de la clase Certificacion.
	 * 
	 * @param tipoCertificacion    Tip	o de certificación.
	 * @param entidadCertificadora Entidad certificadora.
	 * @param idCertificacion      Identificador de la certificación.
	 */
	public Certificacion(String tipoCertificacion, String entidadCertificadora, String idCertificacion) {
		this.tipoCertificacion = tipoCertificacion;
		this.entidadCertificadora = entidadCertificadora;
		this.idCertificacion = idCertificacion;
	}

	// Getters y Setters

	public String getTipoCertificacion() {
		return tipoCertificacion;
	}

	public String getEntidadCertificadora() {
		return entidadCertificadora;
	}

	public String getIdCertificacion() {
		return idCertificacion;
	}

	@Override
	public String toString() {
		return "Certificacion [tipoCertificacion=" + tipoCertificacion + ", entidadCertificadora="
				+ entidadCertificadora + ", idCertificacion=" + idCertificacion + "]";
	}
	
}