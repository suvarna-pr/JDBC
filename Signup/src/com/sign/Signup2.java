package com.sign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup2 extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		
		String u=req.getParameter("username");
		String p=req.getParameter("pwd");
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup", "root", "root");
			PreparedStatement ps=con.prepareStatement("select *from new_table where username=(?) and pwd=(?)");
			
			ps.setString(1,u);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("Logged in successfully");
			}
			else {
				out.println("Invalid user!!");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		out.close();
	}
}
