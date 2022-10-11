package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NullPointerException{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String StudentId=request.getParameter("sid1");
			String FirstName = request.getParameter("firstname1");
			String LastName = request.getParameter("lastname1");
			String PhoneNumber = request.getParameter("pnumber1");
			String Email =  request.getParameter("email1");
		
				
			pw.print(" Information is:</br>");
			pw.print("StudentId:"+StudentId+"</br>");
			pw.print("First Name:"+FirstName+"</br>");
			pw.print("Last Name:"+LastName+"</br>");
			pw.print("Phone Number:"+PhoneNumber+"</br>");
			pw.print("Email:"+Email+"</br>");

			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/white","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into colors values(?,?,?,?,?)");
			ps.setString(1, StudentId);
			ps.setString(2, FirstName);
			ps.setString(3, LastName);
			ps.setString(4,PhoneNumber);
			ps.setString(5, Email);
			int i=ps.executeUpdate();
			if(i>0)
			{
				pw.print("Data inserted successfully");
			}
	
			String[] val=request.getParameterValues("colors2");
			String query2="insert into colors2 values (?,?)";
			PreparedStatement pt1=con.prepareStatement(query2);
			for(int j=0;j<val.length;j++)
			{
				pt1.setString(1,StudentId);
				pt1.setString(2,val[j] );
				pt1.execute();
			}

	
			} 
			catch (ClassNotFoundException e) {
	
			e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
}
}

}


