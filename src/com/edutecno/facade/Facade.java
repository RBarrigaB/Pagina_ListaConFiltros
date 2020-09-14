package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.InscripcionDAO;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.InscripcionDTO;

public class Facade {

	public List<CursoDTO> findAll(){
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.findAll();
	}
	
	public CursoDTO findById(Object id) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.findById(id);
	}
	
	public boolean create(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.create(cursoDto);
	}
	
	public boolean update(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.update(cursoDto);
	}
	
	public boolean delete(CursoDTO cursoDto) {
		CursoDAO cursoDao = new CursoDAO();
		return cursoDao.detele(cursoDto);
	}
	
	public List<InscripcionDTO> obtieneInscripciones(){ // se declara el método obtieneInscripciones
		InscripcionDAO inscripcionDao= new InscripcionDAO(); // se instancia InscripcionDAO con un objeto
		return inscripcionDao.obtieneInscripciones(); //se retorna la lista que tiene como retorno el método obtieneInscripciones
	}
	
	public boolean insertar_inscripcion(Object inscDto) { // se declara el método para insertar un registro
		InscripcionDAO inscripcionDao= new InscripcionDAO();	  // se crea una instancia de InscripcionDAO con un objeto
		return inscripcionDao.insertar_inscripciones(inscDto);	  // se retorna los valores guardados en el objeto
	}
	
	public InscripcionDTO seleccion_por_ids(Object idIns) {
		InscripcionDAO inscripcionDao= new InscripcionDAO();
		return inscripcionDao.seleccion_por_id(idIns);
	}
}
