package co.poli.edu.PatronComposite;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Unidad {
    private String nombre;
    private List<Unidad> unidades; 

    // Constructor corregido sin el parámetro List<Unidad>
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); // Se inicializa la lista correctamente
    }

    public void agregarUnidad(Unidad unidad) {
        if (unidad != null) {
            unidades.add(unidad);
        }
    }

    @Override
    public void mostrarInfo(StringBuilder builder) {
        builder.append("Departamento: ").append(nombre).append("\n");
        for (Unidad unidad : unidades) {
            builder.append("   ");
            unidad.mostrarInfo(builder);
        }
    }
}

