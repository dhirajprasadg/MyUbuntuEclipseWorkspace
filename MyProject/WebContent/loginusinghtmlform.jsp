<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="logins.sp" method="post">
		<table align="center">
			<caption>Login to Application</caption>
			<tbody align="right" style="margin-top: auto;">
				<tr>
					<td align="left">Name :</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>

			</tbody>

		</table>

	</form>
	<br>
	<form action="createaccount.sp" method="post">
		<table>
			<caption style="font-size: medium; font-weight: bold;">Create Account</caption>
			<tbody>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="username" id="username"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" id="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>

			</tbody>

		</table>

	</form>

</body>
</html>