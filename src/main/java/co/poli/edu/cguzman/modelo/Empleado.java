package co.poli.edu.cguzman.modelo;

public class Empleado implements Unidad {
    private String nombre;
    private String cargo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    @Override
    public void mostrarInfo(StringBuilder builder) {
        builder.append("Empleado: ").append(nombre).append(" - Cargo: ").append(cargo).append("\n");
    }
}