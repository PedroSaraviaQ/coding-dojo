<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>New Dojo</title>
	</head>
	<body>
		<p>
			<a href="/ninjas">View ninjas</a>
			<a href="/dojos">View dojos</a>
		</p>

		<form:form method="post" modelAttribute="dojo">
			<h2>New Dojo</h2>
			<p>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</p>
			<button>Create</button>
		</form:form>
	</body>
</html>
