package com.edutecno.dto;

public class FormaDePagoDTO {

	private int idFormaDePago;
	private String descripcion;
	private String recargo;
	
	public FormaDePagoDTO(int idFormaDePago, String descripcion, String recargo) {
		super();
		this.idFormaDePago = idFormaDePago;
		this.descripcion = descripcion;
		this.recargo = recargo;
	}

	public FormaDePagoDTO() {
		super();
	}

	public int getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(int idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRecargo() {
		return recargo;
	}

	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}

	@Override
	public String toString() {
		return "FormaDePagoDTO [idFormaDePago=" + idFormaDePago + ", descripcion=" + descripcion + ", recargo="
				+ recargo + "]";
	}
	
	
}
