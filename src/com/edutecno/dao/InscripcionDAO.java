package com.edutecno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.Conexion;
import com.edutecno.dto.CursoDTO;
import com.edutecno.dto.InscripcionDTO;

public class InscripcionDAO{
	
	private Connection cnx;
	private final String SQL_INSCRIPCIONES_SELECT_ALL = "select id_insc, nombre, clave,rol,celular, id_curso, id_forma_de_pago from inscripcion";
	private final String SQL_INSERT_INSCRIPCIONES="insert into inscripcion(nombre,celular, id_curso, id_forma_de_pago) values(?, ?, ?, ?)";
	private final String SQL_SELECT_ID = "select id_curso, descripcion, precio from curso where id_curso = ?";
	
	public List<InscripcionDTO> obtieneInscripciones() {
		//se crea una lista para almacenar la información obtenida desde la BD
		List<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		// se instancia PrepareStatment
		PreparedStatement ps;
		// se instancia Resultset
		ResultSet rs;
		try {
			cnx = Conexion.obtenerConexion().getConexion(); // Se conecta al servidor
			ps = cnx.prepareStatement(SQL_INSCRIPCIONES_SELECT_ALL); //Se prepara la consulta SQL_INSCRIPCIONES_SELECT_ALL
			rs = ps.executeQuery(); // Se ejecuta la consulta
			while(rs.next()) { // Se recorren los elementos de la tabla inscripciones mientras no tenga valores vacíos
				InscripcionDTO inscpDto = new InscripcionDTO(); // se crea un objeto de la clase InscripcionDTO
				inscpDto.setNombre(rs.getString("nombre"));// se poblan los valores de dicho objeto
				inscpDto.setCelular(rs.getString("celular"));
				inscpDto.setIdCurso(rs.getInt("id_curso"));
				inscpDto.setIdFormaDePago(rs.getInt("id_forma_de_pago"));
				inscripciones.add(inscpDto); // se agrega cada línea del objeto a una lista, mientras el ciclo while permanezca activo
			}
			Conexion.cerrarConexion(cnx); // se cierra la conexion
			return inscripciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertar_inscripciones(Object info) {
		
		// se instancia PrepareStatment
		PreparedStatement ps_input;
		InscripcionDTO nueva_inscripcion= new InscripcionDTO();
		nueva_inscripcion=(InscripcionDTO) info;
		try {
		
			cnx = Conexion.obtenerConexion().getConexion(); // se establece conexión a la base de datos
			ps_input = cnx.prepareStatement(SQL_INSERT_INSCRIPCIONES); // se prepara la sentencia a ejecutar en la base de datos
			ps_input.setString(1, nueva_inscripcion.getNombre()); // se agrega el nombre a la sentencia INSERT, tomada del input del usuario1
			ps_input.setString(2, nueva_inscripcion.getCelular());// se agrega la id de inscripción a la sentencia INSERT, tomada del input del usuario
			ps_input.setInt(3, nueva_inscripcion.getIdCurso());// se agrega id curso a la sentencia INSERT, tomada del input del usuario
			ps_input.setInt(4, nueva_inscripcion.getIdFormaDePago()); //se agrega la id forma de pago a la sentencia INSERT, tomada del input del usuario
			
			if(ps_input.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return false;
	}
	
	public InscripcionDTO seleccion_por_id(Object idIns) {

		PreparedStatement ps;
		ResultSet rs;
		InscripcionDTO data_resumen_insc = null;
		try {
			cnx = Conexion.obtenerConexion().getConexion();
			ps = cnx.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1,(int)idIns);
			rs = ps.executeQuery();
			while(rs.next()) {
				data_resumen_insc = new InscripcionDTO();
				data_resumen_insc.setNombre(rs.getString("nombre"));
				data_resumen_insc.setCelular(rs.getString("celular"));
				data_resumen_insc.setIdCurso(rs.getInt("id_curso"));
				data_resumen_insc.setIdFormaDePago(rs.getInt("id_forma_de_pago"));	
			}
			
			return data_resumen_insc;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}
}
