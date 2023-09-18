<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>New Student</title>
    </head>
    <body>
        <h2>New Student</h2>
        <a href="/students">View students</a>
        <a href="/dorms">View dorms</a>
        
        <form:form method="post" modelAttribute="student">
            <p>
                <form:label path="firstName">First Name:</form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName"/>
                <form:errors path="lastName"/>
            </p>
            <p>
                <form:label path="age">Age:</form:label>
                <form:input path="age" type="number"/>
                <form:errors path="age"/>
            </p>
            <button>Create</button>
        </form:form>
    </body>
</html>
