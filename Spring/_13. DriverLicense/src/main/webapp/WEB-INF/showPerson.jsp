<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Profile Page</title>
	</head>
	<body>
		<h2>${person.firstName} ${person.lastName}</h2>
		<a href="/persons">Dashboard</a>

		<c:if test="${person.license==null}">
			<a href="/licenses/new">Add license</a>
		</c:if>

		<c:if test="${person.license!=null}">
			<table>
				<tr>
					<td>License Number:</td>
					<td>${person.license.number}</td>
				</tr>
				<tr>
					<td>State:</td>
					<td>${person.license.state}</td>
				</tr>
				<tr>
					<td>Expiration Date:</td>
					<td><fmt:formatDate value="${person.license.expirationDate}" pattern="MM/dd/yyyy"/></td>
				</tr>
			</table>
		</c:if>
	</body>
</html>
