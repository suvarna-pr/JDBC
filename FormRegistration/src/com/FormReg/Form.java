package com.FormReg;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String f=req.getParameter("firstname");  
		String m=req.getParameter("middlename");  
		String l=req.getParameter("lastname");  
		String d=req.getParameter("dob"); 
		String g=req.getParameter("gender");  
		String a=req.getParameter("address");  
		String mb=req.getParameter("mob");  
		String e=req.getParameter("email");
		String c=req.getParameter("course");  
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeevithasuvr", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into suvarna values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,f);
			ps.setString(2,m);
			ps.setString(3,l);
			ps.setString(4,d);
			ps.setString(5,g);
			ps.setString(6,a);
			ps.setString(7,mb);
			ps.setString(8,e);
			ps.setString(9,c);
			int i=ps.executeUpdate();  
			if(i>0)  
			out.print("You are successfully registered...");  
			ps.execute();
			con.close();           
		}
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}  
		          
		out.close(); 
		
	}

}
