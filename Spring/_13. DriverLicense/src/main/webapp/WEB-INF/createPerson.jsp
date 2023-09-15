<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>New Person</title>
	</head>
	<body>
		<h2>New Person</h2>
		<a href="/persons">Dashboard</a>

		<form:form method="post" modelAttribute="person">
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"/>
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"/>
			</p>
			<button>Create</button>
		</form:form>
	</body>
</html>
