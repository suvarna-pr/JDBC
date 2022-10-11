6<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Language</title>
</head>
<body>
<form action="">
<h3>View Details</h3>
<label for="languageDetails">Select Language:</label>
<select name="language" >
 
  <option value="C">C</option>
  <option value="C++">C++</option>
  <option value="Java">Java</option>
  <option value="Any">Any</option>
</select><br>
<input type="submit" value="Submit">
</form>

<%
String language = request.getParameter("colors2");
if(language != null){
%>
<table>
<tr>
<td>Student Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Phone Number</td>
<td>Email Id</td>
<td>Language</td>
<tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=DriverManager.getConnection("jdbc:mysql:/localhost:3306/white","root","root");
ResultSet rs=null;
if(language.equals("Any"))
{
	PreparedStatement ps = con.prepareStatement("select r.sid,r.firstname,r.lastname,r.pnumber,r.email,l.language from colors r,colors2 l where r.sid = l.sid  ");
	rs = ps.executeQuery();
}	
else
{
PreparedStatement ps = con.prepareStatement("select r.sid,r.firstname,r.lastname,r.pnumber,r.email,l.language from colors r,colors2 l where r.sid = l.sid and l.language= ?");
ps.setString(1, language);
 rs = ps.executeQuery();
}
%>
<%while(rs.next()){ %>
<tr>
<td><%=rs.getString("sid")%></td>
<td><%=rs.getString("firstname")%></td>
<td><%=rs.getString("lastname")%></td>
<td><%=rs.getString("pnumber")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("language")%></td>
</tr>
<%} %>
<%
}
catch(ClassNotFoundException e){
e.printStackTrace();
}

} %>
</table>
</body>
</html>
