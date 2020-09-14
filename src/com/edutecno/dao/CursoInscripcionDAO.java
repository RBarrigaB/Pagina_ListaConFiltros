package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.Conexion;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.CursoInscripcionDTO;
import com.edutecno.dto.InscripcionDTO;

public class CursoInscripcionDAO {

	private final String SQL_MULTI_TABLA = "select * from curso c inner join inscripcion i on c.id_curso = i.id_curso where c.id_curso = ?;";
	private Connection cnn;
	public List<CursoInscripcionDTO> findAllByCurso(Object id){
		PreparedStatement ps;
		ResultSet rs;
		List<CursoInscripcionDTO> cursosInscripcion = new ArrayList<CursoInscripcionDTO>();
		try {
			cnn = Conexion.obtenerConexion().getConexion();
			ps = cnn.prepareStatement(SQL_MULTI_TABLA);
			ps.setInt(1,(int) id);
			rs = ps.executeQuery();
			while(rs.next()) {
				CursoDTO curso = new CursoDTO();
				InscripcionDTO inscripcion = new InscripcionDTO();
				CursoInscripcionDTO cursoInscripcion = new CursoInscripcionDTO();
				curso.setIdCurso(rs.getInt("id_curso"));
				curso.setDescripcion(rs.getString("descripcion"));
				inscripcion.setNombre(rs.getString("nombre"));
				inscripcion.setIdInsc(rs.getInt("id_insc"));
				inscripcion.setCelular(rs.getString("celular"));
				cursoInscripcion.setCursoDto(curso);
				cursoInscripcion.setInscripcionDto(inscripcion);
				cursosInscripcion.add(cursoInscripcion);
			}
			return cursosInscripcion;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
