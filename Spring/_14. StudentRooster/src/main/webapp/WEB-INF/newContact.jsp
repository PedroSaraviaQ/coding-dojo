<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>New Contact</title>
    </head>
    <body>
        <h2>New Contact</h2>
        <a href="/students">View students</a>
        
        <form:form method="post" modelAttribute="contact">
            <p>
                <form:label path="student">Student:</form:label>
                <form:select path="student">
                    <c:forEach items="${students}" var="student">
                        <c:if test="${student.contact==null}">
                            <form:option value="${student}">${student.firstName} ${student.lastName}</form:option>
                        </c:if>
                    </c:forEach>
                </form:select>
                <form:errors path="student"/>
            </p>
            <p>
                <form:label path="address">Address:</form:label>
                <form:input path="address"/>
                <form:errors path="address"/>
            </p>
            <p>
                <form:label path="city">City:</form:label>
                <form:input path="city"/>
                <form:errors path="city"/>
            </p>
            <p>
                <form:label path="state">State:</form:label>
                <form:input path="state"/>
                <form:errors path="state"/>
            </p>
            <button>Create</button>
        </form:form>
    </body>
</html>
