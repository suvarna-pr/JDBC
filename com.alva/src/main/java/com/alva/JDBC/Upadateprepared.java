package com.alva.JDBC;

import java.sql.*;
import java.util.Scanner;

public class Upadateprepared {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con6= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		PreparedStatement ps2=con6.prepareStatement("update student set name=? where id=?");
		System.out.println("Enter new name to update");
		String name=sc.next();
		System.out.println("Enter the id");
		int id=sc.nextInt();
		
		
		ps2.setString(1,name);
		ps2.setInt(2,id);
		
		ps2.execute();
		con6.close();
	}

}
