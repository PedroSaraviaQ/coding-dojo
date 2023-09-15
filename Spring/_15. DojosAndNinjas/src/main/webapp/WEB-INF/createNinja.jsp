<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>New Ninja</title>
	</head>
	<body>
		<p>
			<a href="/ninjas">View ninjas</a>
			<a href="/dojos">View dojos</a>
		</p>

		<form:form method="post" modelAttribute="ninja">
			<h2>New Ninja</h2>
			<p>
				<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo}">${dojo.name}</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="first_name">First Name:</form:label>
				<form:input path="first_name"/>
				<form:errors path="first_name"/>
			</p>
			<p>
				<form:label path="last_name">Last Name:</form:label>
				<form:input path="last_name"/>
				<form:errors path="last_name"/>
			</p>
			<p>
				<form:label path="age">Age:</form:label>
				<form:input path="age" type="number"/>
				<form:errors path="age"/>
			</p>
			<button>Create</button>
		</form:form>
	</body>
</html>
