package co.poli.edu.cguzman.composite;

public class Empleado implements Unidad {

	private String nombre;
	private String cargo;

	/**
	 * Constructor de la clase Empleado.
	 * 
	 * @param nombre Nombre del empleado.
	 * @param cargo  Cargo del empleado.
	 */
	public Empleado(String nombre, String cargo) {
		this.nombre = nombre;
		this.cargo = cargo;
	}

	/**
	 * Método para mostrar la información del empleado.
	 */
	@Override
	public void mostrarInformación(StringBuilder builder) {
		builder.append("Empleado: ").append(nombre).append(", Cargo: ").append(cargo).append("\n");
	}

}