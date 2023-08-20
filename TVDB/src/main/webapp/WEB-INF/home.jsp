<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>TVDB</title>
        <link rel="stylesheet" href="/css/home.css">
    </head>
    <body>
        <h1>Bienvenidos a TVDB!</h1>

        <form:form action="/" method="post" modelAttribute="user">
            <h2>Registrarte</h2>
            <p>
                <form:label path="name">Nombre:</form:label>
                <form:input type="text" path="name"/>
                <form:errors cssClass="error" path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
                <form:errors cssClass="error" path="email"/>
                <span class="error"><c:out value="${uniqueEmail}"/></span>
            </p>
            <p>
                <form:label path="password">Contraseña:</form:label>
                <form:input type="password" path="password"/>
                <form:errors cssClass="error" path="password"/>
            </p>
            <p>
                <form:label path="passwordConfirmation">Confirmación:</form:label>
                <form:input type="password" path="passwordConfirmation"/>
                <form:errors cssClass="error" path="passwordConfirmation"/>
                <span class="error"><c:out value="${matchError}"/></span>
            </p>
            <button>Registrarte</button>
        </form:form>
    </body>
</html>
