<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Secret Code</title>
    </head>
    <body>
        <form action="/" method="post">
            <p style="color: red"><c:out value="${error}"/></p>
            <p>What is the code?</p>
            <input type="text" name="code">
            <button>Try Code</button>
        </form>
    </body>
</html>
