<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	
	<form action="RegistrationForm" method="post">
	
	<br>
	<br><br>
	<br>
	<h1>Registration</h1>
	<table>
	<tr><td>Student Id</td><td><input type="text" name="sid1" required></td></tr>
	<tr><td>First Name</td><td><input type="text" name="firstname1" required></td></tr>
	
	<tr><td>Last Name</td><td><input type="text" name="lastname1" required></td></tr>
	
	<tr><td>Phone Number</td><td><input type="tel" name="pnumber1" required></td></tr>

	<tr><td>E-mail</td><td><input type="email" name="email1" required><br></td></tr>
	
	<tr><td>Language</td><td>
	<input type="checkbox" name=language  value="C" >
	<label for="C">C</label>
	<input type="checkbox" name=language  value="C++" >
	<label for="C++">C++</label>
	<input type="checkbox" name=language  value="Java" >
	<label for="Java">Java</label>
	<input type="checkbox" name=language  value="Any" >
	<label for="Any">Any</label>
	</td></tr>
		</table>
		<br>
		<br>
	<input type="submit">                          
	</form>
	</center>
</body>
</html>