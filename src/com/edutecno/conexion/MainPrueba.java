package com.edutecno.conexion;


import java.sql.SQLException;

import com.edutecno.facade.Facade;

public class MainPrueba {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Facade facade= new Facade();
		System.out.println(facade.obtieneInscripciones());
	}

}
