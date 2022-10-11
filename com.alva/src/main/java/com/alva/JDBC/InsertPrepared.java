package com.alva.JDBC;

import java.sql.*;
import java.util.Scanner;

public class InsertPrepared {
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con4= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		PreparedStatement ps=con4.prepareStatement("insert into student values(?,?,?,?)");
		System.out.println("Enter the ID Name Email and Cno");
		int id=sc.nextInt();
		String name=sc.next();
		String Email=sc.next();
		String cno=sc.next();

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3,Email);
		ps.setString(4,cno);
		
		ps.execute();
		con4.close();
		
	}

}
