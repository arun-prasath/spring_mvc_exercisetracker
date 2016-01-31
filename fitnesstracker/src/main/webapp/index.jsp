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
</body>
</html>
