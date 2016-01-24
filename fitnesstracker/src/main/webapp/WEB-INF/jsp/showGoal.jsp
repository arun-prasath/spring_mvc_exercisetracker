<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Goal ID</td>
			<td>Minutes</td>
			<td>Exercises</td>
		</tr>
		<c:forEach items="${goals}" var="goal">
			<tr>
				<td>${goal.goalId}</td>
				<td>${goal.minutes}</td>
				<td>
					<table>
						<c:forEach items="${goal.exercise}" var="exercise">
							<tr>
								<td>${exercise.exerciseId}</td>
								<td>${exercise.minutes}
							</tr>
						</c:forEach>
						
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>