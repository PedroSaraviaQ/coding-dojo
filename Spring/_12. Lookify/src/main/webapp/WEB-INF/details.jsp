<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Details</title>
		<link rel="stylesheet" href="/css/delete.css">
	</head>
	<body>
		<a href="/dashboard">Dashboard</a>
		<table>
			<tr>
				<td>Title</td>
				<td>${song.title}</td>
			</tr>
			<tr>
				<td>Artist</td>
				<td>${song.artist}</td>
			</tr>
			<tr>
				<td>Rating (1-10)</td>
				<td>${song.rating}</td>
			</tr>
		</table>

		<form:form action="/songs/${song.id}" method="delete">
			<input type="hidden" name="_method" value="delete">
			<button class="button-as-link">delete</button>
		</form:form>
	</body>
</html>
