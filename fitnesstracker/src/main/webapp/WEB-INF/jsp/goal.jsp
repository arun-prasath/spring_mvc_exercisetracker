<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add goal</title>
<style type="text/css">
.error {
	color: red;
}

.errorBlock {
	color: red;
	background-color: #ffa4a4;
	padding: 3px;
	border: 3px solid #c31515;
	margin: 8px;
}
</style>
</head>
<body>
<form:form modelAttribute="goal" >
	<form:errors path="*" cssClass="errorBlock" />
	<table>
		<tr>
			<td>Goal</td>
			<td><form:input path="minutes" cssErrorClass="error" /></td>
			<td><form:errors path="minutes" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3"><form:button>Enter goal</form:button></td>
		</tr>
	</table>
</form:form>
</body>
</html>