package com.alva.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Viewprepared {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con6= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		PreparedStatement ps2=con6.prepareStatement("select *from student where id=?");
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		ps2.setInt(1,id);
		
		ResultSet rs=ps2.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		ps2.close();
		con6.close();
	}

}
