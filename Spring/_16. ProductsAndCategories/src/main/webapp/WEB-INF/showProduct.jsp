<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product Page</title>
    </head>
    <body>
        <h1>${product.name}</h1>
        <p>
            <a href="/products">View products</a>
            <a href="/categories">View categories</a>
        </p>
        
        <h2>Categories:</h2>
        <ul>
            <c:forEach items="${product.categories}" var="category">
                <li>${category.name}</li>
            </c:forEach>
        </ul>
        
        <form:form action="/products/${product.id}/categories" method="put">
            <input type="hidden" name="_method" value="put">
            <label>
                Add Category:
                <select name="categoryId">
                    <c:forEach items="${categories}" var="category">
                        <c:if test="${!product.categories.contains(category)}">
                            <option value="${category.id}">${category.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </label>
            <button>Add</button>
        </form:form>
    </body>
</html>
