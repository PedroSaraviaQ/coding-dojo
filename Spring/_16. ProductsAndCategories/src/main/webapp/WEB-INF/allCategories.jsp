<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Categories</title>
    </head>
    <body>
        <h2>All Categories</h2>
        <p>
            <a href="/categories/new">New Category</a>
            <a href="/products">View products</a>
        </p>
        
        <ul>
            <c:forEach items="${categories}" var="category">
                <li>
                    <a href="/categories/${category.id}">${category.name}</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
