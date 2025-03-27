package co.poli.edu.cguzman.modelo;

public class AdapterPayPal implements IPago {

	private PayPal payPal;

	public AdapterPayPal(PayPal payPal) {
		this.payPal = new PayPal();
	}

	public void hacerPago(double monto) {
		this.payPal.pagar(monto);
	}

}