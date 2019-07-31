<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>List Customer JSP Page</title>

<!-- reference our stylesheet -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager-CRM</h2>
		</div>	
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- put new button add customer -->
		<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd';return false;"
		class="add-button"
		/>
		
			<!-- Add Out Our html -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					
					<!-- Loop over and print all customers -->
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>
					</c:forEach>
				</table>
			
		</div>
	</div>
</body>
</html>