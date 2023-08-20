<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Detalles</title>
    </head>
    <body>
        <h1><c:out value="${program.title}"/></h1>
        <a href="/programas">Volver al panel</a>
        <p>Red de Televisión: <c:out value="${program.network}"/></p>
        <p>Descripción <c:out value="${program.description}"/></p>
        <a href="/programas/${program.id}/editar">Editar</a>

        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${reviews}" var="review">
                <tr>
                    <td><c:out value="${review.user.name}"/></td>
                    <td><c:out value="${review.rating}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <form action="/programas/${program.id}/rating" method="post">
            <label for="rating">Deja una calificación:</label>
            <input type="number" name="rating" id="rating" min="1" max="5" step="0.1"/>
            <button>Califica!</button>
        </form>
    </body>
</html>
