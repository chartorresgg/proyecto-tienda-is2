package co.poli.edu.cguzman.composite;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Unidad {

	private String nombre;
	private List<Unidad> unidades = new ArrayList<>(); // Listado de unidades del departamento.

	/**
	 * Constructor de la clase Departamento.
	 * 
	 * @param nombre   Nombre del departamento.
	 * @param unidades Unidades del departamento.
	 */
	public Departamento(String nombre, Unidad[] unidades) {
		this.nombre = nombre;
	}

	/**
	 * Método para agregar una unidad al departamento.
	 * 
	 * @param unidad Unidad a agregar.
	 */
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	/**
	 * Método para mostrar la información del departamento.
	 */
	@Override
	public void mostrarInfo(StringBuilder builder) {
		builder.append("Departamento: ").append(nombre).append("\n");
		for (Unidad unidad : unidades) {
			unidad.mostrarInfo(builder);
		}
	}

}
