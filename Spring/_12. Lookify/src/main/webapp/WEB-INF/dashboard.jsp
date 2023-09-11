<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Lookify!</title>
		<link rel="stylesheet" href="/css/delete.css">
	</head>
	<body>
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>

		<form action="/search" method="post">
			<input name="artist"/>
			<button>Search Artists</button>
		</form>

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
