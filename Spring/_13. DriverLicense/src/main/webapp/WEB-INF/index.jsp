<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Dashboard</title>
	</head>
	<body>
		<h2>Dashboard</h2>
		<a href="/persons/new">Add person</a>

		<table>
			<tr>
				<th>Name</th>
				<th>License</th>
			</tr>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td>
						<a href="/persons/${person.id}">${person.firstName} ${person.lastName}</a>
					</td>
					<td>
						<c:if test="${person.license==null}">
							-
						</c:if>
						<c:if test="${person.license!=null}">
							${person.license.number}
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
