<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
.failed{
	color:red;
}
</style>

<title>Login Page</title>
</head>
<body>


<h3>My Custom  Login Page</h3>

<!-- check for login error -->
<c:if test="${param.error!=null }">
	<i class="failed">Sorry you entered wrong username/password</i>
</c:if>

<form:form action="${pageContext.request.contextPath }/authenticateTheUser" method="POST">
	<p>Username:<input type="text" name="username" placeholder="Username"></p>
	<p>Password:<input type="password" name="password" placeholder="password"></p>
	<input type="submit" value="Login">
</form:form>

</body>
</html>