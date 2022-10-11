package com.alva.JDBC;
import java.sql.*;
import java.util.Scanner;
public class Deleteprepared {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con5= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		PreparedStatement ps1=con5.prepareStatement("delete from student where id=?");
		System.out.println("Enter the id to delete the row");
		int id=sc.nextInt();
		ps1.setInt(1, id);
		ps1.execute();
		con5.close();
	}

}
