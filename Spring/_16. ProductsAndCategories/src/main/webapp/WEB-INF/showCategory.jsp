<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Category Page</title>
    </head>
    <body>
        <h1>${category.name}</h1>
        <p>
            <a href="/categories">View categories</a>
            <a href="/products">View products</a>
        </p>
        
        <h2>Products:</h2>
        <ul>
            <c:forEach items="${category.products}" var="product">
                <li>${product.name}</li>
            </c:forEach>
        </ul>
        
        <form:form action="/categories/${category.id}/products" method="put">
            <input type="hidden" name="_method" value="put">
            <label>
                Add Product:
                <select name="productId">
                    <c:forEach items="${products}" var="product">
                        <c:if test="${!category.products.contains(product)}">
                            <option value="${product.id}">${product.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </label>
            <button>Add</button>
        </form:form>
    </body>
</html>
