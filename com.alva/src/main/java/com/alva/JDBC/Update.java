package com.alva.JDBC;

import java.sql.*;
public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement smt2= con2.createStatement();
		smt2.execute("update student set Name='suma' where ID=6");
		smt2.execute("update student set Name='jee',cno='006325' where ID=6");
		smt2.close();
		con2.close();
	}
}
