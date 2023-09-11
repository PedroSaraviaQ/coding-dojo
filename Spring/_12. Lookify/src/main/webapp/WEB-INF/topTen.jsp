<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Top 10</title>
	</head>
	<body>
		<h1>Top Ten Songs:</h1>
		<a href="/dashboard">Dashboard</a>

		<ul>
			<c:forEach items="${songs}" var="song">
				<li>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</li>
			</c:forEach>
		</ul>
	</body>
</html>
