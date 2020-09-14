package com.edutecno.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.InscripcionDTO;
import com.edutecno.facade.Facade;

@WebServlet("/posInscripcion")

public class PosInscripcion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// obtengo los datos del formulario
		String nombre = request.getParameter("nombre");
		String celular = request.getParameter("telefono");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));

		// instancio el objeto DTO y le asigno los datos
		InscripcionDTO dto = new InscripcionDTO();
		dto.setNombre(nombre);
		dto.setCelular(celular);
		dto.setIdCurso(idCurso);
		dto.setIdFormaDePago(idFormaDePago);
		// invoco al facade para procesar la inscripcion
		Facade facade = new Facade();

		if (facade.insertar_inscripcion(dto) == true) {
			
			request.setAttribute("inscrito", dto);

			InscripcionDTO data = new InscripcionDTO();
			data = (InscripcionDTO) request.getAttribute("inscrito");
			request.setAttribute("inscripcion_nueva", data);
		}

		// redirecciono el control hacia la siguiente vista,
		// es decir: hacia su servlet de pre-confirmacion
		request.getRequestDispatcher("/preConfirmacion").forward(request, response);
	}
}
