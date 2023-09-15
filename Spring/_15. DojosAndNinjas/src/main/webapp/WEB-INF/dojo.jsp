<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Dojo Page</title>
	</head>
	<body>
		<p>
			<a href="/ninjas">View ninjas</a>
			<a href="/dojos">View dojos</a>
		</p>

		<h2>${dojo.name} Location Ninjas</h2>

		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
			<c:forEach items="${dojo.ninjas}" var="ninja">
				<tr>
					<td>${ninja.first_name}</td>
					<td>${ninja.last_name}</td>
					<td>${ninja.age}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
