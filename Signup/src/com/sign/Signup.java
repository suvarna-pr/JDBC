package com.sign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String u=request.getParameter("username");
		String p=request.getParameter("pwd");
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into  new_table values(?,?)");
			ps.setString(1,u);
			ps.setString(2,p);
			int i=ps.executeUpdate();  
			if(i>0)  
			out.print("You are successfully registered...");  
			RequestDispatcher rd=request.getRequestDispatcher("signup4.html");
			rd.forward(request, response);  	
		}
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}  
		          
		out.close(); 
	
	}

	
}
