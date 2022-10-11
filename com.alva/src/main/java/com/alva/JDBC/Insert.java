package com.alva.JDBC;
import java.sql.*;
public class Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement smt= con.createStatement();
		smt.execute("insert into student values(5,'jeevitha','jeevi@gmail.com','9865456')");
		smt.close();
		con.close();
	}
	
}
