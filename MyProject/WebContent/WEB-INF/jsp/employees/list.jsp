<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Employees</title>
<link rel="stylesheet" href="/MyProject/resources/style.css" type="text/css">
</head>
<body>
	<h1>List of employees</h1>
	<a href="employees?new">Add new employee</a>
	<table cellspacing="5" class="main-table">
		<tr>
			<th>Name</th>
			<th>Department</th>
			<th>Details</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="#{employees}" var="emp">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.department}</td>
				<td><a href="employees/find/${emp.id}">Find </a></td>
				<td><a href="employees/load/${emp.id}">Load</a></td>
				<td><a href="employees/preparedstEmployee/${emp.id}"> preparedstEmployee </a></td>
				<td><sf:form action="employees/${emp.id}" method="delete" cssClass="delete">
						<input type="submit" class="delete-button" value="Delete" />
					</sf:form></td>
			</tr>
		</c:forEach>
	</table>
	<a href="welcome">Go back</a>
</body>
</html>