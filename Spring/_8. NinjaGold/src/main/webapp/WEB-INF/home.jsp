<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Ninja Gold Game</title>
        <link rel="stylesheet" href="css/form.css">
    </head>
    <body>
        <p>Your Gold: <c:out value="${gold}"/></p>
        <form action="/reset" method="post">
            <button>Reset</button>
        </form>

        <div class="container">
            <form action="/" method="post">
                <p>Farm</p>
                <p>(earns 10-20 gold)</p>
                <input type="hidden" name="activity" value="farm">
                <button>Find Gold!</button>
            </form>
            <form action="/" method="post">
                <p>Cave</p>
                <p>(earns 5-10 gold)</p>
                <input type="hidden" name="activity" value="cave">
                <button>Find Gold!</button>
            </form>
            <form action="/" method="post">
                <p>House</p>
                <p>(earns 2-5 gold)</p>
                <input type="hidden" name="activity" value="house">
                <button>Find Gold!</button>
            </form>
            <form action="/" method="post">
                <p>Casino!</p>
                <p>(earns/takes 0-50 gold)</p>
                <input type="hidden" name="activity" value="casino">
                <button>Find Gold!</button>
            </form>
        </div>

        <h2>Activities:</h2>
        <c:forEach var="activity" items="${activities}">
            <c:if test='${activity.contains("Ouch")}'>
                <p style="color:red">${activity}</p>
            </c:if>
            <c:if test='${!activity.contains("Ouch")}'>
                <p style="color:green">${activity}</p>
            </c:if>
        </c:forEach>
    </body>
</html>
