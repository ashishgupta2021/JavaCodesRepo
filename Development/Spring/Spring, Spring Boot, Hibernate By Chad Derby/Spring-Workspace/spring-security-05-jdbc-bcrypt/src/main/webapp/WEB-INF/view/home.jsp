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
	
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(Only for Managers)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	
		<!-- Add a link to point to /leaders ... this is for the Admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>(Only for Admins)
		</p>
	</security:authorize>
		
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	</form:form>
	
</body>
</html>