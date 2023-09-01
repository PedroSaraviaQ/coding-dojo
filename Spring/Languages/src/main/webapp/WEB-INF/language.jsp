<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${language.name}</title>
        <link rel="stylesheet" href="/css/language.css">
    </head>
    <body>
        <a href="/languages">Dashboard</a>
        <p><c:out value="${language.name}"/></p>
        <p><c:out value="${language.creator}"/></p>
        <p><c:out value="${language.currentVersion}"/></p>

        <a href="/languages/${language.id}/edit">Edit</a>
        <form:form action="/languages/${language.id}" method="delete">
            <input type="hidden" name="_method" value="delete">
            <button class="anchor-button">Delete</button>
        </form:form>
    </body>
</html>
