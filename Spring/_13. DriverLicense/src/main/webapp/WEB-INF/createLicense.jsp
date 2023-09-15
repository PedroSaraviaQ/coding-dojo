<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>New License</title>
	</head>
	<body>
		<h2>New License</h2>
		<a href="/persons">Dashboard</a>

		<form:form method="post" modelAttribute="license">
			<p>
				<form:label path="person">Person:</form:label>
				<form:select path="person">
					<c:forEach items="${persons}" var="person">
						<form:option value="${person}" disabled="${person.license!=null}">
							${person.firstName} ${person.lastName}
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="state">State:</form:label>
				<form:input path="state"/>
				<form:errors path="state"/>
			</p>
			<p>
				<form:label path="expirationDate">Expiration Date:</form:label>
				<form:input path="expirationDate" type="date"/>
				<form:errors path="expirationDate"/>
			</p>
			<button>Create</button>
		</form:form>
	</body>
</html>
