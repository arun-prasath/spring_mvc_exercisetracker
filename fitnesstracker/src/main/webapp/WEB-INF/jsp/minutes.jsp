<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minutes</title>
</head>
<body>
<h2>Goal set for ${goal.minutes} minutes</h2>
<form:form commandName="exercise" method="post">
	Language: <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
	<table>
		<tr>
			<td><spring:message code="goal.text" /></td>
			<td><form:input path="minutes"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<form:button>Enter Exercise</form:button>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>