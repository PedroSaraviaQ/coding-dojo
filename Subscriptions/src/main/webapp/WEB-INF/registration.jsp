<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Subscriptions</title>
    </head>
    <body>
        <form:form action="/register" method="post" modelAttribute="customer">
            <h2>Register</h2>
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input path="email" type="email"/>
                <form:errors path="email"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:input path="password" type="password"/>
                <form:errors path="password"/>
            </p>
            <p>
                <form:label path="passwordConfirmation">Password Conf:</form:label>
                <form:input path="passwordConfirmation" type="password"/>
                <form:errors path="passwordConfirmation"/>
            </p>
            <button>Register</button>
        </form:form>
        
        <form action="/login" method="post">
            <h2>Login</h2>
            <p>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${email}">
                <span>${emailError}</span>
            </p>
            <p>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" value="${password}">
                <span>${passwordError}</span>
            </p>
            <button>Login</button>
        </form>
    </body>
</html>
