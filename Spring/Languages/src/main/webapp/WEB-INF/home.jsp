<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Languages</title>
        <link rel="stylesheet" href="/css/home.css">
    </head>
    <body>
        <table>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>action</th>
            </tr>
            <c:forEach items="${languages}" var="language">
                <tr>
                    <td><a href="/languages/${language.id}">${language.name}</a></td>
                    <td>${language.creator}</td>
                    <td>${language.currentVersion}</td>
                    <td>
                        <form:form action="/languages/${language.id}" method="delete" class="delete-form">
                            <input type="hidden" name="_method" value="delete">
                            <button class="anchor-button">delete</button>
                        </form:form>
                        <a href="/languages/${language.id}/edit">edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form:form action="/languages" method="post" modelAttribute="language">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <p>
                <form:label path="creator">Creator:</form:label>
                <form:input path="creator"/>
                <form:errors path="creator"/>
            </p>
            <p>
                <form:label path="currentVersion">Version:</form:label>
                <form:input path="currentVersion"/>
                <form:errors path="currentVersion"/>
            </p>
            <button>Submit</button>
        </form:form>
    </body>
</html>
