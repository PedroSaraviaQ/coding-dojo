<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Ninjas</title>
	</head>
	<body>
		<p>
			<a href="/ninjas/new">Add ninja</a>
			<a href="/dojos/new">Add dojo</a>
		</p>

		<h2>List of Ninjas</h2>

		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Dojo</th>
			</tr>
			<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td>${ninja.first_name}</td>
					<td>${ninja.last_name}</td>
					<td>${ninja.age}</td>
					<td>${ninja.dojo.name}</td>
				</tr>
			</c:forEach>
		</table>

		<a href="/dojos">View dojos</a>
	</body>
</html>
