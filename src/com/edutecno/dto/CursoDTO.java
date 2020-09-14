package com.edutecno.dto;

public class CursoDTO {

	private int id_curso;
	private String descripcion;
	private double precio;
	
	public CursoDTO(int idCurso, String descripcion, double precio) {
		super();
		this.id_curso = idCurso;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public CursoDTO() {
		super();
	}

	public int getIdCurso() {
		return id_curso;
	}

	public void setIdCurso(int idCurso) {
		this.id_curso = idCurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CursoDTO [idCurso=" + id_curso + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
}
