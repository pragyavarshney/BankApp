<!DOCTYPE html>
<html>
<body>

<h2>Contact Information</h2>
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

<form action="/BankApp/cinfo" method="post">
  <label for="address">Address:</label><br>
  <input type="text" id="address" name="address" value=""><br><br>
  <label for="city">City:</label><br>
  <input type="text" id="city" name="city" value=""><br><br>
  <label for="state">State:</label><br>
  <input type="text" id="state" name="state" value=""><br><br>
   <label for="country">Country:</label><br>
  <input type="text" id="country" name="country" value=""><br><br> 
  <label for="phone">Phone:</label><br>
  <input type="text" id="phone" name="phone" value=""><br><br>
   <label for="email">Email Id:</label><br>
  <input type="text" id="email" name="email" value=""><br><br>
  
  <input type="submit" value="Submit">
</form> 


</body>
</html>