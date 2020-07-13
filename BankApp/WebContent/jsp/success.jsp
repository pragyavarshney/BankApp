
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome2JSP</title>
</head>
<body>
<font color = blue>First Name:</font><%=session.getAttribute("fn") %></br>
<font>Middle Name:</font><%=session.getAttribute("mn") %></br>
<font>Last Name:</font><%=session.getAttribute("ln") %></br>

</body>
</html>