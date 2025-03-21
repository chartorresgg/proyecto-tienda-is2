package co.poli.edu.cguzman.composite;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Unidad {

	private String nombre;
	private List<Unidad> unidades; // Listado de unidades del departamento.

	/**
	 * Constructor de la clase Departamento.
	 * 
	 * @param nombre   Nombre del departamento.
	 * @param unidades Unidades del departamento.
	 */
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.unidades = new ArrayList<>();
	}

	/**
	 * Método para agregar una unidad al departamento.
	 * 
	 * @param unidad Unidad a agregar.
	 */
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	public List<Unidad> getUnidades() {
		return new ArrayList<>(unidades); // Evita modificación externa
	}

	/**
	 * Método para mostrar la información del departamento.
	 */
	@Override
	public void mostrarInformación(StringBuilder builder) {
		builder.append("Departamento: ").append(nombre).append("\n");
		for (Unidad unidad : unidades) {
			unidad.mostrarInformación(builder);
		}
	}

}
