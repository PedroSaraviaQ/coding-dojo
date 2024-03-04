<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Subscriptions</title>
    </head>
    <body>
        <h2>Welcome, ${customer.name}!</h2>
        <a href="/logout">Logout</a>
        
        <p>Your Current Package: ${customer.subscription.name}</p>
        <p>Package Cost: $${customer.subscription.price}</p>
        
        <form:form action="/users/${customer.id}/package" method="put">
            <h2>Switch Package</h2>
            <input type="hidden" name="_method" value="put">
            <select name="subscriptionId">
                <c:forEach items="${subscriptions}" var="subscription">
                    <c:if test="${subscription.available && subscription.id!=customer.subscription.id}">
                        <option value="${subscription.id}">${subscription.name}</option>
                    </c:if>
                </c:forEach>
            </select>
            <button>Switch</button>
        </form:form>
    </body>
</html>
