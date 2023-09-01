<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Create Book</title>
    </head>
    <body>
        <h1>Create a Book!</h1>

        <form:form action="/books" method="post" modelAttribute="book">
            <p>
                <form:label path="title">Name</form:label>
                <form:input path="title" type="text"/>
                <form:errors path="title"/>
            </p>
            <p>
                <form:label path="description">Description</form:label>
                <form:input path="description" type="text"/>
                <form:errors path="description"/>
            </p>
            <p>
                <form:label path="language">Language</form:label>
                <form:input path="language" type="text"/>
                <form:errors path="language"/>
            </p>
            <p>
                <form:label path="numberOfPages">Number of Pages</form:label>
                <form:input path="numberOfPages" type="number"/>
                <form:errors path="numberOfPages"/>
            </p>
            <button>Submit</button>
        </form:form>
    </body>
</html>
