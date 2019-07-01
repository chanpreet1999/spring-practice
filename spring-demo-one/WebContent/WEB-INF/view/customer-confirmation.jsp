<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Customer Confirmation Page</title>
</head>
<body>

Customer name: ${customer.firstName } ${customer.lastName }
<br><br>

Free passes: ${customer.freePasses}
<br><br>

Postal Code: ${customer.postalCode }
</body>
</html>