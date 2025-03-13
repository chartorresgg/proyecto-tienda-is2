package co.poli.edu.cguzman.modelo;

import java.util.List;

/**
 * Clase que representa un Pedido realizado por un Cliente.
 */
public class Pedido {
	private String numero;
	private String fecha;
	private Cliente cliente;
	private List<Producto> productos;

	/**
	 * Constructor de la clase Pedido.
	 * 
	 * @param numero
	 * @param fecha
	 * @param cliente
	 * @param productos
	 */
	public Pedido(String numero, String fecha, Cliente cliente, List<Producto> productos) {
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}

	// Métodos Setters y Getters

	public String getNumero() {
		return numero;
	}

	public String getFecha() {
		return fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * Devuelve una representación en forma de cadena del objeto Pedido. Incluye el
	 * número de pedido, la fecha, el cliente asociado y la lista de productos.
	 *
	 * @return Una cadena con los detalles del pedido en formato estructurado.
	 */
	@Override
	public String toString() {
		return "Pedido{" + "numero='" + numero + "', fecha='" + fecha + "', cliente=" + cliente + ", productos="
				+ productos + "}";
	}
}
