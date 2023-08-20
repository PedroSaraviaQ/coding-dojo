<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Programa</title>
        <link rel="stylesheet" href="/css/newProgram.css">
    </head>
    <body>
        <h1>Agregar un nuevo programa</h1>

        <form:form action="/programas/nuevo" method="post" modelAttribute="program">
            <p>
                <form:label path="title">Título:</form:label>
                <form:input type="text" path="title"/>
                <form:errors cssClass="error" path="title"/>
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

    </body>
</html>