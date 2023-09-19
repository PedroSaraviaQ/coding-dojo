<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>New Category</title>
    </head>
    <body>
        <h2>New Category</h2>
        <p>
            <a href="/categories">View categories</a>
            <a href="/products">View products</a>
        </p>
        
        <form:form method="post" modelAttribute="category">
            <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <button>Create</button>
        </form:form>
    </body>
</html>
