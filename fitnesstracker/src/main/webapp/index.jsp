<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Welcome, <sec:authentication property="name"/>!</h2>
</body>
</html>
