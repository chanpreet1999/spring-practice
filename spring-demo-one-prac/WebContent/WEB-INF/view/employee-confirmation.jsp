<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Confirmation | JSP Page</title>
</head>

<body>
The Employee Confirmed is: ${employee.firstName } ${employee.lastName }
<br><br>

Free Passes: ${employee.freePasses }
<br><br>

Preferred programming Language: ${employee.programmingLanguage}
<br><br>

Nationality: ${employee.country }
<br><br>

Operating Systems Preferences: 
<ul>
<c:forEach var="temp" items="${employee.operatingSystems }" >
<li> ${temp }  </li>
</c:forEach>
</ul>
<br>

Contact Number: ${employee.phno }
<br><br>

Course Enrolled in: ${employee.courseCode }
<br><br>
</body>

</html>