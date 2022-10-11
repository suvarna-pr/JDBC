package com.alva.JDBC;

import java.sql.*;
public class Viewstu {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement smt3= con3.createStatement();
		ResultSet rs=smt3.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString("E-mail")+" "+rs.getString(4));
		}
		smt3.close();
		con3.close();
}

}
