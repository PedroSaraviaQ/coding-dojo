<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Editar Programa</title>
    </head>
    <body>
        <form:form action="/programas/${program.id}/editar" method="put" modelAttribute="program">
            <h1><c:out value="${program.title}"/></h1>
            <input type="hidden" name="_method" value="put"/>
            <p>
                <form:label path="title">Título:</form:label>
                <form:input type="text" path="title"/>
                <form:errors cssClass="error" path="title"/>
                <span class="error"><c:out value="${matchError}"/></span>
            </p>
            <p>
                <form:label path="network">Red:</form:label>
                <form:input type="text" path="network"/>
                <form:errors cssClass="error" path="network"/>
            </p>
            <p>
                <form:label path="description">Descripción:</form:label>
                <form:input type="text" path="description"/>
                <form:errors cssClass="error" path="description"/>
            </p>
            <button>Enviar</button>
        </form:form>

        <form:form action="/programas/${id}/eliminar" method="delete">
            <input type="hidden" name="_method" value="delete"/>
            <button>Eliminar</button>
        </form:form>
    </body>
</html>
