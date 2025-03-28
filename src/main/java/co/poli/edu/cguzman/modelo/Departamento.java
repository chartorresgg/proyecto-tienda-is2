package co.poli.edu.cguzman.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Unidad {
	
	// Atributos
	private String nombre;
	private List<Unidad> unidades;

	// Constructor
	public Departamento(String nombre) {
		this.nombre = nombre;
		this.unidades = new ArrayList<>(); // Se inicializa la lista correctamente
	}

	/**
	 * Agrega una unidad a la lista de unidades
	 * 
	 * @param unidad Unidad a agregar
	 */
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);

	}

	@Override
	public void mostrarInfo(StringBuilder builder) {
		builder.append(nombre).append("\n");
		for (Unidad unidad : unidades) {
			if (unidad instanceof Departamento) {
				builder.append("\n"); // Espacio adicional solo entre departamentos
			}
			unidad.mostrarInfo(builder);
		}
	}
}
