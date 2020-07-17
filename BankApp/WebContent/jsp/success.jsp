
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WelcomePage</title>
</head>
<body>
<h3>Personal Information:</h3>
<jsp:useBean id="pinfo" class ="vo.PersonalInfoBean" scope="session"/>
<p>First Name:
<jsp:getProperty property="firstname" name="pinfo"/><br>
<p>Middle Name:
<jsp:getProperty property="middlename" name="pinfo"/><br>
<p>Last Name:
<jsp:getProperty property="lastname" name="pinfo"/><br>
<p>Gender : 
<jsp:getProperty property="gender" name="pinfo"/><br>
<p>==================================================================
<h3>Contact Information:</h3>
<jsp:useBean id="cinfo" class ="vo.ContactInfoBean" scope="session"/>
<p >Address : 
<jsp:getProperty property="address" name="cinfo"/><br>
<p>City : <jsp:getProperty property="city" name="cinfo"/><br>
<p>State : <jsp:getProperty property="state" name="cinfo"/><br>
<p>Country : <jsp:getProperty property="country" name="cinfo"/><br>
<p >Phone Number : <jsp:getProperty property="phone" name="cinfo"/><br>
<p >Email Id : <jsp:getProperty property="email" name="cinfo"/><br>
<p>==================================================================
<h3>Bank Information:</h3>
<jsp:useBean id="binfo" class ="vo.BankInfoBean" scope="session"/>
<p>Bank Name : <jsp:getProperty property="bankName" name="binfo"/><br>
<p>Account No. :<jsp:getProperty property="account" name="binfo"/><br>
<p >SSN : <jsp:getProperty property="ssn" name="binfo"/>

</body>
</html>