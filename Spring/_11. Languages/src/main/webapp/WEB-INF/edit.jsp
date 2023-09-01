<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${language.name}</title>
        <link rel="stylesheet" href="/css/edit.css">
    </head>
    <body>
        <form:form action="/languages/${language.id}" method="delete" class="delete-form">
            <input type="hidden" name="_method" value="delete">
            <button class="anchor-button">Delete</button>
        </form:form>
        <a href="/languages">Dashboard</a>

        <form:form action="/languages/${language.id}" method="put" modelAttribute="language">
            <input type="hidden" name="_method" value="put">
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
