<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Students</title>
    </head>
    <body>
        <p>
            <a href="/students/new">New Student</a>
            <a href="/contacts/new">New Contact</a>
            <a href="/dorms">View dorms</a>
        </p>
        
        <table>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.firstName} ${student.lastName}</td>
                    <td>${student.age}</td>
                    <c:if test="${student.contact!=null}">
                        <td>${student.contact.address}</td>
                        <td>${student.contact.city}</td>
                        <td>${student.contact.state}</td>
                    </c:if>
                    <c:if test="${student.contact==null}">
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
