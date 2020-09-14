package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.InscripcionDTO;
import com.edutecno.dto.FormaDePagoDTO;
import com.edutecno.facade.Facade;

@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//obtenemos el facade
		Facade facade = new Facade();
		//obtenemos las listas
		List<InscripcionDTO> listaInscripciones = null;
		listaInscripciones = facade.obtieneInscripciones();
		
		//guardo las listas al request
		request.setAttribute("lista_inscripciones", listaInscripciones);
		
		//mandamos el request a la pagina jsp
		request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
	}
}
