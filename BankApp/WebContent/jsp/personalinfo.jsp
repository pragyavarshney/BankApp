<!DOCTYPE html>
<html>
<body>

<h2>Personal Information</h2>
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

<form action="/BankApp/pls" method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" value=""><br><br>
  <label for="mname">Middle name:</label><br>
  <input type="text" id="mname" name="mname" value=""><br><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" value=""><br><br>
   Gender:<br>
  <input type="radio" id="male" name="gender" value="male">
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="female">
  <label for="female">Female</label>
  <input type="radio" id="other" name="gender" value="other">
  <label for="other">Other</label><br><br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>