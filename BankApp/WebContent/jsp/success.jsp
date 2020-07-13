
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WelcomePage</title>
</head>
<body>

<br>
Welcome
<font></font><%=session.getAttribute("fn") %>
<font></font><%=session.getAttribute("mn") %>
<font></font><%=session.getAttribute("ln") %></br></br>
<font>Gender:</font><%=session.getAttribute("gn") %></br></br>
<font >Address:</font><%=session.getAttribute("add") %></br></br>
<font>City:</font><%=session.getAttribute("city") %></br></br>
<font>State:</font><%=session.getAttribute("state") %></br></br>
<font>Country:</font><%=session.getAttribute("country") %></br></br>
<font >Phone Number:</font><%=session.getAttribute("phone") %></br></br>
<font>Bank Name:</font><%=session.getAttribute("bn") %></br></br>
<font>Acc. No.:</font><%=session.getAttribute("acc") %></br></br>
<font >SSN:</font><%=session.getAttribute("ssn") %></br>

</body>
</html>