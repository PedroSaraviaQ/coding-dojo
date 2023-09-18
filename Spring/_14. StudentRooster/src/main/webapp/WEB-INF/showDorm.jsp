<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Show Dormitory</title>
        <link rel="stylesheet" href="/css/button-link.css">
    </head>
    <body>
        <h2>${dorm.name} Dormitory</h2>
        <p>
            <a href="/students">View students</a>
            <a href="/dorms">View dorms</a>
        </p>
        
        <form:form action="/dorms/${dorm.id}/students" method="put">
            <input type="hidden" name="_method" value="put">
            <p>
                <label>
                    Students:
                    <select name="studentId">
                        <c:forEach items="${students}" var="student">
                            <option value="${student.id}">
                                    ${student.firstName} ${student.lastName}
                            </option>
                        </c:forEach>
                    </select>
                </label>
            </p>
            <button>Add</button>
        </form:form>
        
        <table>
            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${dorm.students}" var="student">
                <tr>
                    <td>${student.firstName} ${student.lastName}</td>
                    <td>
                        <form:form action="/dorms/${dorm.id}/students" method="delete">
                            <input type="hidden" name="_method" value="delete">
                            <input type="hidden" name="studentId" value="${student.id}">
                            <button class="button-link">Remove</button>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
