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
import com.edutecno.facade.*;

@WebServlet("/preListarInscripciones")

            public class PreListarInscripciones extends HttpServlet {
			private static final long serialVersionUID = 1L;

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			//se obtiene el facade
			Facade facade = new Facade();
			try {
				
				//obtenemos las lista requerida
				List<InscripcionDTO> listainscripciones= facade.obtieneInscripciones();
				//se almacena la lista en un request
				request.setAttribute("lista_inscripciones", listainscripciones);
				
				//enviamos el request a la página JSP solicitada
				request.getRequestDispatcher("ListaInscripciones.jsp").forward(request, response);
			
			} catch (Exception e) {
		
				e.printStackTrace();
			}
}
}