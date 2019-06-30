<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<! DOCTYPE html>
<html>

<head>

<title>Student Registration Form</title>

</head>

<body>
<form:form action="processForm" method="GET" modelAttribute="student">

First Name:<form:input path="firstName"/>
<br><br>

Last Name:<form:input path="lastName"/>
<br><br>

Country:<form:select path="country">

          <form:options items= "${student.countryOptions }" />
</form:select>
<br><br>

<input type="submit" value="submit">
</form:form>
</body>

</html>