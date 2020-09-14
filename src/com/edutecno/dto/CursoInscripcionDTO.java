package com.edutecno.dto;

public class CursoInscripcionDTO {

	private CursoDTO cursoDto;
	private InscripcionDTO inscripcionDto;
	
	public CursoInscripcionDTO(CursoDTO cursoDto, InscripcionDTO inscripcionDto) {
		super();
		this.cursoDto = cursoDto;
		this.inscripcionDto = inscripcionDto;
	}

	public CursoInscripcionDTO() {
		super();
	}

	public CursoDTO getCursoDto() {
		return cursoDto;
	}

	public void setCursoDto(CursoDTO cursoDto) {
		this.cursoDto = cursoDto;
	}

	public InscripcionDTO getInscripcionDto() {
		return inscripcionDto;
	}

	public void setInscripcionDto(InscripcionDTO inscripcionDto) {
		this.inscripcionDto = inscripcionDto;
	}

	@Override
	public String toString() {
		return "CursoInscripcionDTO [cursoDto=" + cursoDto + ", inscripcionDto=" + inscripcionDto + "]";
	}
	
	

}
