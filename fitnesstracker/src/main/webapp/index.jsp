<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Welcome, <sec:authentication property="name"/>!</h2>
<br/>
<br/>
<a href="addGoal.html">Add Goal</a>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<a href="#">Edit Goal</a>
</sec:authorize>
<a href="j_spring_security_logout">Logout</a>
</body>
</html>
