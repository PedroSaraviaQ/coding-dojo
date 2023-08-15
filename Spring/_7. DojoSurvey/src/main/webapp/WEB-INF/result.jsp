<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Dojo Survey Index</title>
    </head>
    <body>
        <h2>Submitted Info</h2>
        <p>Name: <c:out value="${name}"/></p>
        <p>Dojo Location: <c:out value="${location}"/></p>
        <p>Favorite Language: <c:out value="${language}"/></p>
        <p>Comment: <c:out value="${comment}"/></p>
        <form action="/result" method="post">
            <button>Go Back</button>
        </form>
    </body>
</html>
