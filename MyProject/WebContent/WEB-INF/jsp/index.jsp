<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet" href="/MyProject/resources/style.css" type="text/css">

<!--  <script>
  var $ = jQuery.noConflict();
</script>
 -->
<%-- <link href="${pageContext.request.contextPath}/js/jquery.min.js" rel="text/javascript"> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
 --%>
<script type="text/javascript">
        var contexPath = "<%=request.getContextPath()%>";
</script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/user.js"></script>
 --%>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/app.css"> --%>

<style type="text/css">
.cente {
	align: center;
	border: 8px;
	border-color: red;
	margin-left: 80%;
	text-decoration: none;
	margin-bottom: 10%;
	color: white;
	padding: 10px;
	background-color: blue;
}
</style>
</head>
<body>

	
	<jsp:include page="/resources/_menu.jsp"></jsp:include>
	
	<form:form method="post" modelAttribute="loginFormfromindex" name="loginFormfromindex" action="loginuser.sp">
		<table align="center">
			<tr>
				<td>
					<h2>Login to Your Account:</h2>
				</td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input name="userName" type="textbox"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Submit"></td>
			</tr>
		</table>
		<div style="color: red">${error}</div>
	</form:form>
	<form:form method="post" modelAttribute="addUserloginForm" name="addUserloginForm" action="addloginuser.sp">
		<table align="center">
			<tr>
				<td>
					<h2>Create Account:</h2>
				</td>
			</tr>
			<tr>
			<tr>
				<td>ID:</td>
				<td><input name="id" type="textbox"></td>
			</tr>
			<tr>
				<td>User Name :</td>
				<td><input name="userName" type="textbox"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td>isactive:</td>
				<td><input name="isactive" type="textbox"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Submit"></td>
			</tr>
		</table>
		<div style="color: red">${error}</div>
	</form:form>
	<br>

	<%
		String username = (String) request.getSession().getAttribute("UserAdded");
	%>

	<c:if test="${not empty '<% username %>'}">
	 <h2 style="color: green" align="center"> Hello "${sessionScope.UserAdded }" Your account created </h2>

	</c:if>

	<br>
	<h1>Welcome to the Timesheet App!</h1>
	<ul>
		<li><a href="managers">List managers</a></li>
		<li><a href="employees">List employees</a></li>
		<li><a href="tasks">List tasks</a></li>
		<li><a href="timesheets">List timesheets</a></li>
	</ul>
	<h2>
		Also check out <a href="timesheet-service">extra services!</a>
	</h2>
	Today is:
	<fmt:formatDate value="${today}" pattern="dd-MM-yyyy" />

	<br>

	<a class="cente" href="loginusinghtmlform.jsp"> Login Using HTML form </a>

</body>



</html>

</body>
</html>