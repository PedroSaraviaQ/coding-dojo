<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Book Info</title>
    </head>
    <body>
        <h1><c:out value="${book.title}"/></h1>
        <p>Description: <c:out value="${book.description}"/></p>
        <p>Language: <c:out value="${book.language}"/></p>
        <p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
        <a href="/books/${book.id}/edit">Edit Book</a>

        <form:form action="/books/${book.id}" method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete</button>
        </form:form>
    </body>
</html>


