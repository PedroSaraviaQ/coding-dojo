<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>New Product</title>
    </head>
    <body>
        <h2>New Product</h2>
        <p>
            <a href="/products">View products</a>
            <a href="/categories">View categories</a>
        </p>
        
        <form:form method="post" modelAttribute="product">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <p>
                <form:label path="description">Description:</form:label>
                <form:textarea path="description"/>
                <form:errors path="description"/>
            </p>
            <p>
                <form:label path="price">Price:</form:label>
                <form:input path="price" type="number"/>
                <form:errors path="price"/>
            </p>
            <button>Create</button>
        </form:form>
    </body>
</html>
