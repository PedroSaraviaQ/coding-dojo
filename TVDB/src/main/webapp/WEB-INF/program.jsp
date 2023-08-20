<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Detalles</title>
    </head>
    <body>
        <h1><c:out value="${program.title}"/></h1>
        <p>Red de Televisión: <c:out value="${program.network}"/></p>
        <p>Descripción <c:out value="${program.description}"/></p>
        <a href="/programas/${program.id}/editar">Editar</a>
    </body>
</html>
