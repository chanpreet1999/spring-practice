<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<! DOCTYPE html>
<html>

<head>

<title>Student Registration Form</title>

</head>

<body>
<form:form action="processForm" method="POST" modelAttribute="student">

<!-- input column -->
First Name:<form:input path="firstName"/>
<br><br>

Last Name:<form:input path="lastName"/>
<br><br>

<!-- form select dropdown menu -->
Country:<form:select path="country">
          <form:options items= "${student.countryOptions }" />
</form:select>
<br><br>

<!-- radio button -->
Java<form:radiobutton path="favouriteLanguage" value="Java"/>
C#<form:radiobutton path="favouriteLanguage" value="C#" />
PHP<form:radiobutton path="favouriteLanguage" value="PHP"/>
Ruby<form:radiobutton path="favouriteLanguage" value="Ruby"/>
<br><br>

<!-- checkbox -->
Operating Systems:<br>
MS Windows:<form:checkbox path="operatingSystems" value="MS Windows"/>
Mac OS:<form:checkbox path="operatingSystems" value="Mac OS"/>
Linux:<form:checkbox path="operatingSystems" value="Linux" />
<br><br>

<input type="submit" value="submit">
</form:form>
</body>

</html>