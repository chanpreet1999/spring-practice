<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Confirmation | JSP Page</title>
</head>

<body>
The Employee Confirmed is: ${employee.firstName } ${employee.lastName }
<br><br>

Preferred programming Language: ${employee.programmingLanguage}
<br><br>

Nationality: ${employee.country }
<br><br>
</body>

</html>