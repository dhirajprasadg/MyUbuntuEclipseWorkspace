<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>

<!-- <link rel="stylesheet" type="text/css" href="styles.css">
 -->
 
<link rel="stylesheet" href="/MyProject/resources/style.css" type="text/css">

</head>
<body>

	
	<jsp:include page="/resources/_menu.jsp"></jsp:include>
	
	<h3>Add Product</h3>
	<form:form modelAttribute="productForm" method="post" enctype="multipart/form-data" action="addProducts.sp">
		<table>
			<tr>
				<td>Code</td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>

			<tr style="padding-top: 10px">
				<td>Upload Image</td>
				<td><form:input type="file" path="fileData" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>

	</form:form>
	<%-- 
	<h3>Add Product Image </h3>
	<form:form modelAttribute="productFormimage" method="post" enctype="multipart/form-data" action="addProductsgetimage.sp"  >
		<table>
			<tr>
				<td>Code</td>
				<td><form:input path="code" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><form:input path="price" /></td>
			</tr>

			<tr style=" padding-top: 10px">
				<td>Upload Image</td>
				<td><form:input type="file" path="fileData" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>

	</form:form>

 --%>

</body>
</html>