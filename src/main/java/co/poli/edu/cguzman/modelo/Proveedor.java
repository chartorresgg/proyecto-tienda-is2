package co.poli.edu.cguzman.modelo;

public class Proveedor {

	private String nit;
	private String nombre;
	private String dirección;
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
	 * @param certificacion   Certificación del proveedor.
	 * @param politicaEntrega Política de entrega del proveedor.
	 */
	private Proveedor(Builder builder) {
		this.nit = builder.nit;
		this.nombre = builder.nombre;
		this.dirección = builder.dirección;
		this.evaluacion = builder.evaluacion;
		this.certificacion = builder.certificacion;
		this.politicaEntrega = builder.politicaEntrega;
	}

	/**
	 * Método para obtener el NIT del proveedor.
	 * 
	 * @return NIT del proveedor.
	 */
	public static class Builder {
		private String nit;
		private String nombre;
		private String dirección;
		private Evaluacion evaluacion;
		private Certificacion certificacion;
		private PoliticaEntrega politicaEntrega;

		public Builder nit(String nit) {
			this.nit = nit;
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder dirección(String dirección) {
			this.dirección = dirección;
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

		public Proveedor build() {
			return new Proveedor(this);
		}
	}

	@Override
	public String toString() {
		return "Proveedor [nit=" + nit + ", nombre=" + nombre + ", dirección=" + dirección + ", evaluacion="
				+ evaluacion + ", certificacion=" + certificacion + ", politicaEntrega=" + politicaEntrega + "]";
	}
}
