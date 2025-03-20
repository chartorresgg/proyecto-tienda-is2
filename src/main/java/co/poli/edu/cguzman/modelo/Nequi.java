package co.poli.edu.cguzman.modelo;

public class Nequi {
	
	private String nit;
	private String descripcion;
	public Nequi(String nit, String descripcion) {
		super();
		this.nit = nit;
		this.descripcion = descripcion;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
