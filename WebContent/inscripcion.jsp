<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.dto.InscripcionDTO" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Inscripción</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<% 
	List<InscripcionDTO> inscripciones;
	// capturamos informacion que viene desde el request
	inscripciones     = (List)request.getAttribute("lista_inscripciones");
%>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Mantenedor De Cursos</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="preListarInscripciones">Home</a></li>
      <li><a href="preInscripcion">Inscribir Cursos</a></li>
    </ul>
  </div>
</nav>


<div class="container">
	<form action="posInscripcion">
		  <div class="form-group">
		    <label for="nombre">Nombre:</label>
		    <input type="text" class="form-control" name="nombre">
		  </div>
		  <div class="form-group">
		    <label for="telefono">Telefono:</label>
		    <input type="text" class="form-control" name="telefono">
		  </div>
		  <div class="form-group">
		    <label for="cursos">Cursos:</label>
		    <select name="idCurso">
					  <% 
				  	for(InscripcionDTO dto: inscripciones){
				  %>
				  	<option>
				  			<%=dto.getIdCurso()%>
				  	</option>
				  <% 
				  	}
				  %>
		  </select><br>
		  </div>
		  <div class="form-group">
		    <label for="formasPago">Formas de Pago:</label>
		     <select name="idFormaPago">
				  <% 
				  	for(InscripcionDTO dto : inscripciones){
				  %>
				  	<option>
				  			<%=dto.getIdFormaDePago()%>
				  	</option>
				  <% 
				  	}
				  %>
				  </select><br>
		  </div>
		  
		  <button type="submit" class="btn btn-default">Enviar</button>
	</form>
<div class="container">
</body>
</html>