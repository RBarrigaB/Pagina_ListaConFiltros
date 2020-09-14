<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.edutecno.dto.InscripcionDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Inscripciones</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/estilos.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@1,700&display=swap"
	rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Mantenedor de Cursos</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Inscribir Cursos</a>
      </li>
    </ul>
  </div>
</nav>
<br>
<body class="p-3">

	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">Id Inscripción</th>
				<th scope="col">Nombre</th>
				<th scope="col">Teléfono</th>
				<th scope="col">Id Curso</th>
				<th scope="col">Id Forma de Pago</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dti" items="${lista_inscripciones}">
				<tr>
					<td><c:out value="${ dti.getIdInsc()}"></c:out></td>
					<td><c:out value="${ dti.getNombre()}"></c:out></td>
					<td><c:out value="${ dti.getCelular()}"></c:out></td>
					<td><c:out value="${ dti.getIdCurso()}"></c:out></td>
					<td><c:out value="${ dti.getIdFormaDePago()}"></c:out></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>