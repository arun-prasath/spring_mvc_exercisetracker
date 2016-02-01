<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
.errorBlock {
	color: red;
	background-color: #ffa4a4;
	padding: 3px;
	border: 3px solid #c31515;
	margin: 8px;
}
</style>
</head>
<body onload="document.f.j_username.focus();">
	<h3>Login Page</h3>
	<c:if test="${not empty error}">
		<div class="errorBlock">
			Unsuccessful login. 
			<br />
			Caused by ${sesssionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	
	<form action="j_spring_security_check" name="f" method="post" >
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="j_username"/>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password" />
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><input type="reset" value="Reset" /></td>
		</table>
	</form>


</body>
</html>