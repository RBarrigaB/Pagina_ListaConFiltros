<%@ page import=" com.edutecno.dto.InscripcionDTO"%>
<% InscripcionDTO datos= new InscripcionDTO(); 

   datos=(InscripcionDTO)request.getAttribute("inscripcion_nueva");

%>

<html> 
<body>
   <h1>Registro exitoso</h1><br>
   <h3>Nombre de alumno: <%=datos.getNombre()%></h3>
    <h3>Teléfono de contacto: <%=datos.getCelular()%></h3>
     <h3>Id de curso: <%=datos.getIdCurso()%></h3>
      <h3>Id forma de pago: <%=datos.getIdFormaDePago()%></h3>
</body>
</html>