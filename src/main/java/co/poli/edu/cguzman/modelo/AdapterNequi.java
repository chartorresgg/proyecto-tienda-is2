package co.poli.edu.cguzman.modelo;

public class AdapterNequi implements IPago {

	private Nequi nequi;

	/**
	 * Constructor de la clase AdapterNequi.
	 * 
	 * @param nequi Objeto de la clase Nequi.
	 */
	public AdapterNequi(Nequi nequi) {
		this.nequi = new Nequi();
	}

	/**
	 * Método para hacer un pago.
	 * 
	 * @param monto Monto a pagar.
	 */
	public void hacerPago(double monto) {
		nequi.pagar(monto);
	}

}
