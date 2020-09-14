package com.edutecno.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/desafio_listar_inscripciones?serverTimezone=UTC";
	private static String usuario = "root";
	private static String pass = "root";
	
	private static Conexion dataSource = null;
	private BasicDataSource basicDataSource = null;
	
	private Conexion() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(usuario);
		basicDataSource.setPassword(pass);
		
		basicDataSource.setMinIdle(5);
		basicDataSource.setMaxIdle(10);
		basicDataSource.setMaxTotal(100);
		basicDataSource.setMaxWaitMillis(10000);
	}
	
	public static Conexion obtenerConexion() {
		if(dataSource == null) {
			dataSource = new Conexion();
		}
		return dataSource;
	}
	
	public Connection getConexion() throws SQLException {
		return this.basicDataSource.getConnection();
	}
	
	public static void cerrarConexion(Connection cnn) throws SQLException {
		cnn.close();
	}
}
