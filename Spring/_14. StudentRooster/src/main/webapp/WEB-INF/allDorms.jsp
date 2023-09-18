<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>All Dormitories</title>
    </head>
    <body>
        <h2>All Dormitories</h2>
        <a href="/students">View students</a>
        <a href="/dorms/new">New Dorm</a>
        
        <table>
            <tr>
                <th>Dorm</th>
                <th>#Students</th>
            </tr>
            <c:forEach items="${dorms}" var="dorm">
                <tr>
                    <td>
                        <a href="/dorms/${dorm.id}">${dorm.name}</a>
                    </td>
                    <c:if test="${dorm.students!=null}">
                        <td>${dorm.students.size()}</td>
                    </c:if>
                    <c:if test="${dorm.students==null}">
                        <td>${0}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
