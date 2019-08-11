<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Luv2code company Home page</title>
</head>
<body>
<h2>Luv 2 Code company home page</h2>
<hr>
Luv2Code Company Home Page
<br>
<form:form action="${pageContext.request.contextPath }/logout" method="POST">
<input type="submit" value="Logout"></input>
</form:form>
</body>

</html>