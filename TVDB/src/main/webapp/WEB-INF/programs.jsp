<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>TVDB</title>
    </head>
    <body>
        <h1>Bienvenidos, <c:out value="${currentUser.name}"/>!</h1>

        <form action="/logout" method="post">
            <button>Cerrar sesión</button>
        </form>

        <h2>Programas</h2>

        <table>
            <thead>
            <tr>
                <th>Programa</th>
                <th>Red</th>
                <th>Descripción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${programs}" var="program">
                <tr>
                    <td><a href="/programas/${program.id}">${program.title}</a></td>
                    <td>${program.network}</td>
                    <td>${program.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="/programas/nuevo">Agregar un Programa</a>
    </body>
</html>
