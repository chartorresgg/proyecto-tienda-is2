package co.poli.edu.cguzman.modelo;

public class AdapterPayPal implements IPago {

	private PayPal payPal;

	public AdapterPayPal(PayPal payPal) {
		this.payPal = new PayPal();
	}

	@Override
	public String hacerPago(double monto) {
		return payPal.pagarConPayPal(monto); // Solo retorna el mensaje

	}

}