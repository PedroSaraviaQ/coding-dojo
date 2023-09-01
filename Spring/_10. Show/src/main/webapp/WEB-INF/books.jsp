<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Books</title>
    </head>
    <body>
        <h1>List of Books</h1>

        <p><a href="/books/create">Create Book</a></p>

        <ul>
            <c:forEach items="${books}" var="book">
                <li>
                    <a href="/books/${book.id}">${book.title}</a>: ${book.description}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
