<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Employee Form | JSP Page</title>
<style type="text/css">
.error{color: red}
</style>
</head>
<body>

<i>Fields marked with (*) are mandatory</i>
<br><br>

<form:form action="processEmployee" modelAttribute="employee">

First Name:<form:input path="firstName" />
<form:errors path="firstName" cssClass="error" />
<br><br>

Last Name:(*)<form:input path="lastName" />
<form:errors path="lastName" cssClass="error" />
<br><br>

Free Passes:<form:input path="freePasses" />
<form:errors path="freePasses" cssClass="error" />
<br><br>

<!-- dropdown menu -->
Select Country: <form:select path="country">
	<form:options items="${employee.countryOptions }"/>
</form:select>
<br><br>

<!-- radio button -->
Preferred Programming Language: 
Java <form:radiobutton path="programmingLanguage" value="Java" />
C++ <form:radiobutton path="programmingLanguage" value="C++" />
PHP <form:radiobutton path="programmingLanguage" value="PHP"/>
<br><br>

<!-- checkbox -->
Operating Systems:<br>
Windows<form:checkbox path="operatingSystems" value="Windows" />
Mac<form:checkbox path="operatingSystems" value="MacOS" />
Linux<form:checkbox path="operatingSystems" value="Linux" />
<br><br>

Phone Number: <form:input path="phno" />
<form:errors path="phno" cssClass="error" />
<br><br>

Course:<form:input path="courseCode" />
<form:errors path="courseCode" cssClass="error" />
<br><br>

<input type="submit" value="Submit" />
<br><br>

</form:form>

</body>
</html>