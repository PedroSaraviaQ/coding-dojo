<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Search</title>
		<link rel="stylesheet" href="/css/delete.css">
	</head>
	<body>
		<p>Songs by artist: ${artist}</p>

		<form action="/search" method="post">
			<input name="artist" value="${artist}"/>
			<button>New Search</button>
		</form>

		<a href="/dashboard">Dashboard</a>

		<table>
			<tr>
				<th>Name</th>
				<th>rating</th>
				<th>actions</th>
			</tr>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td>
						<form:form action="/songs/${song.id}" method="delete">
							<input type="hidden" name="_method" value="delete">
							<button class="button-as-link">delete</button>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
