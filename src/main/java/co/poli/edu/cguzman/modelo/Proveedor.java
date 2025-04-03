package co.poli.edu.cguzman.modelo;

/**
 * Clase Proveedor.
 * 
 * Esta clase contiene los atributos y métodos de un proveedor.
 * 
 * @version 1.0
 */
public class Proveedor {

	private String nit;
	private String nombre;
	private String direccion;
	private Evaluacion evaluacion;
	private Certificacion certificacion;
	private PoliticaEntrega politicaEntrega;

	/**
	 * Constructor de la clase Proveedor.
	 * 
	 * @param nit             NIT del proveedor.
	 * @param nombre          Nombre del proveedor.
	 * @param dirección       Dirección del proveedor.
	 * @param evaluacion      Evaluación del proveedor.
	 * @param certificacion   S Certificación del proveedor.
	 * @param politicaEntrega Política de entrega del proveedor.
	 */
	private Proveedor(Builder builder) {

		this.nit = builder.nit;
		this.nombre = builder.nombre;
		this.direccion = builder.direccion;
		this.evaluacion = builder.evaluacion;
		this.certificacion = builder.certificacion;
		this.politicaEntrega = builder.politicaEntrega;
	}

	
	/**
	 * Método para obtener el NIT del proveedor.
	 * 
	 * @return NIT del proveedor.
	 * clase innerStatic 
	 */
	public static class Builder {

		private String nit;
		private String nombre;
		private String direccion;
		private Evaluacion evaluacion;
		private Certificacion certificacion;
		private PoliticaEntrega politicaEntrega;
		
		/**
		 * Constructor de la clase Builder.
		 * 
		 * @param nit NIT del proveedor.
		 */

		public Builder nit(String nit) {
			this.nit = nit;
			return this;
		}
		
		/**
		 * Método para obtener el nombre del proveedor.
		 * 
		 * @return Nombre del proveedor.
		 */

		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder direccion(String direccion) {
			this.direccion = direccion;
			return this;
		}

		public Builder evaluacion(Evaluacion evaluacion) {
			this.evaluacion = evaluacion;
			return this;
		}

		public Builder certificacion(Certificacion certificacion) {
			this.certificacion = certificacion;
			return this;
		}

		public Builder politicaEntrega(PoliticaEntrega politicaEntrega) {
			this.politicaEntrega = politicaEntrega;
			return this;
		}

		/**
		 * Método que construye todo el objeto
		 * @return
		 */
		public Proveedor build() {
			return new Proveedor(this);
		}
	}

	// Getters
	public String getNit() {
		return nit;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public Certificacion getCertificacion() {
		return certificacion;
	}

	public PoliticaEntrega getPoliticaEntrega() {
		return politicaEntrega;
	}


	@Override
	public String toString() {
		return "Proveedor [nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion + ", evaluacion="
				+ evaluacion + ", certificacion=" + certificacion + ", politicaEntrega=" + politicaEntrega + "]";
	}
}
