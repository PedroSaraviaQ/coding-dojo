<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Add Song</title>
	</head>
	<body>
		<a href="/dashboard">Dashboard</a>

		<form:form action="/songs/new" method="post" modelAttribute="song">
			<p>
				<form:label path="title">Title</form:label>
				<form:input path="title"/>
				<form:errors path="title"/>
			</p>
			<p>
				<form:label path="artist">Artist</form:label>
				<form:input path="artist"/>
				<form:errors path="artist"/>
			</p>
			<p>
				<form:label path="rating">Rating (1-10)</form:label>
				<form:input path="rating" type="number" min="1" max="10" step="1"/>
				<form:errors path="rating"/>
			</p>
			<button>Add Song</button>
		</form:form>
	</body>
</html>
