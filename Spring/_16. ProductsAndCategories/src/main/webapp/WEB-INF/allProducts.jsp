<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Products</title>
    </head>
    <body>
        <h2>All Products</h2>
        <p>
            <a href="/products/new">New Product</a>
            <a href="/categories">View categories</a>
        </p>
        
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><a href="/products/${product.id}">${product.name}</a></td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
