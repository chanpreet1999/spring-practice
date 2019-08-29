<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
  <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Luv2code company Home page</title>
</head>
<body>
<h2>Luv 2 Code company home page</h2>
<hr>

<p>
User:<security:authentication property="principal.username"/>
<br><br>
Role(s):<security:authentication property="principal.authorities"/>
</p>

<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(Only for Manager peeps)
	</p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath }/systems">Systems Meeting</a>(Only For Admins )
	</p>
</security:authorize>

<hr>
Luv2Code Company Home Page
<br><br>
<form:form action="${pageContext.request.contextPath }/logout" method="POST">
<input type="submit" value="Logout"></input>
</form:form>
</body>

</html>