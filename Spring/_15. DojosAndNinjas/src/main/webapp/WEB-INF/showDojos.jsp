<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Dojos</title>
	</head>
	<body>
		<p>
			<a href="/ninjas/new">Add ninja</a>
			<a href="/dojos/new">Add dojo</a>
		</p>

		<h2>List of Dojos</h2>

		<ul>
			<c:forEach items="${dojos}" var="dojo">
				<li>
					<a href="/dojos/${dojo.id}">${dojo.name}</a>: ${dojo.ninjas.size()} ninjas
				</li>
			</c:forEach>
		</ul>

		<a href="/ninjas">View ninjas</a>
	</body>
</html>
