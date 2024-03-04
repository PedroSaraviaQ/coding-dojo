<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Subscriptions</title>
    </head>
    <body>
        <h2>Package: ${subscription.name}</h2>
        
        <form:form action="/packages/${subscription.id}/update" method="put">
            <input type="hidden" name="_method" value="put">
            <p>
                <label for="price">Cost:</label>
                <input type="number" id="price" name="price" min="0" step="0.01" value="${subscription.price}" required>
            </p>
            <button>Edit</button>
        </form:form>
        
        <form:form action="/packages/${subscription.id}/delete" method="delete">
            <input type="hidden" name="_method" value="delete">
            <button>Delete</button>
            <span>${error}</span>
        </form:form>
    </body>
</html>
