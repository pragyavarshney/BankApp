<!DOCTYPE html>
<html>
<body>

<h2>Bank Information</h2>
<%
		Object obj = request.getAttribute("errors");
	String pageErrors = "";
	if (obj != null) {
		pageErrors = (String) obj;
	%>
	<font color=red><%=pageErrors%></font>
	<%
		}
	%>

<form action="/BankApp/bif" method="post">
  <label for="bname">Bank name:</label><br>
  <input type="text" id="bname" name="bname" value=""><br><br>
  
  <label for="account">Account #:</label><br>
  <input type="text" id="account" name="account" value=""><br><br>
  
  <label for="ssn">SSN:</label><br>
  <input type="text" id="ssn" name="ssn" value=""><br><br>
  
  <input type="submit" value="Submit">
</form> 


</body>
</html>