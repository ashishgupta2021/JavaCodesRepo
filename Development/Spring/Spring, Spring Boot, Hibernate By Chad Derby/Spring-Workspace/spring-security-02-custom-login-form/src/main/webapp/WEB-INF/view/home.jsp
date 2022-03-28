<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
	<title>Company Home Page</title>
</head>
<body>
	<h2>Company Home page</h2>
	
	<hr>
	<p>Welcome to Home Page</p>

	<hr>
	
	<!-- Display user name and role -->
	<p>
		User: <security:authentication property="principal.username" />  
		<br><br>
		Roles: <security:authentication property="principal.authorities" />
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>