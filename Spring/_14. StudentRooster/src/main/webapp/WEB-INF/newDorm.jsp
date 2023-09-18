<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>New Dormitory</title>
    </head>
    <body>
        <h2>New Dormitory</h2>
        
        <form:form method="post" modelAttribute="dorm">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Create</button>
        </form:form>
        
        <p>
            <a href="/students">View students</a>
            <a href="/dorms">View dorms</a>
        </p>
    </body>
</html>
