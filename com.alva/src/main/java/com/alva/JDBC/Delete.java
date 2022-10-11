package com.alva.JDBC;
import java.sql.*;
public class Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement smt1= con1.createStatement();
		smt1.execute("delete from student where id=47");
		smt1.close();
		con1.close();
	}


}
