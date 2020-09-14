package com.edutecno.conexion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.CursoDTO;
import com.edutecno.facade.Facade;

/**
 * Servlet implementation class PostInscripcion
 */
@WebServlet("/PostInscripcion")
public class PostInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String idCurso = request.getParameter("idCurso");
		Facade facade = new Facade();
		CursoDTO curso = facade.findById(Integer.parseInt(idCurso));
		request.setAttribute("cursoInscripcion", curso);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		RequestDispatcher rd = request.getRequestDispatcher("PreConfirmacion");
		rd.forward(request, response);
	}

}
