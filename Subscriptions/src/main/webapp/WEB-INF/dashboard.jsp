<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Subscriptions</title>
    </head>
    <body>
        <h1>Admin Dashboard</h1>
        <a href="/logout">Logout</a>
        
        <h2>Customers</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Next Due Date</th>
                <th>Amount Due</th>
                <th>Package Type</th>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <c:if test="${customer.id!=1}">
                    <tr>
                        <td>${customer.name}</td>
                        <td><fmt:formatDate value="${customer.createdAt}"/></td>
                        <td>$${customer.subscription.price}</td>
                        <td>${customer.subscription.name}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        
        <h2>Packages</h2>
        <table>
            <tr>
                <th>Package Name</th>
                <th>Package Cost</th>
                <th>Available</th>
                <th>Users</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${subscriptions}" var="subscription">
                <tr>
                    <td>${subscription.name}</td>
                    <td>$${subscription.price}</td>
                    <td>${subscription.available ? "available" : "unavailable"}</td>
                    <td>${subscription.customers==null ? 0 : subscription.customers.size()}</td>
                    <td>
                        <c:if test="${subscription.id==1||subscription.customers.size()!=0}">
                            deactivate
                        </c:if>
                        <c:if
                            test="${subscription.id!=1 && subscription.available && subscription.customers.size()==0}">
                            <a href="/packages/${subscription.id}/available">deactivate</a>
                        </c:if>
                        <c:if
                            test="${subscription.id!=1 && !subscription.available && subscription.customers.size()==0}">
                            <a href="/packages/${subscription.id}/available">activate</a>
                        </c:if>
                        |
                        <a href="/packages/${subscription.id}/edit">edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <form:form method="post" modelAttribute="subscription">
            <h2>Create Package</h2>
            <p>
                <form:label path="name">Package Name:</form:label>
                <form:input path="name"/>
                <form:errors path="name"/>
            </p>
            <p>
                <form:label path="price">Cost:</form:label>
                <form:input path="price" type="number" min="0" step="0.01"/>
                <form:errors path="price"/>
            </p>
            <button>Create new package</button>
        </form:form>
    </body>
</html>
