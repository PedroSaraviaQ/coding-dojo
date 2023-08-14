<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Current visit count</title>
    </head>
    <body>
        <p>You have visited <b>http://localhost:8000</b> <c:out value="${count}"/> times.</p>
        <a href="/">Test another visit?</a>
        <form action="/reset" method="post">
            <button>Reset</button>
        </form>
    </body>
</html>
