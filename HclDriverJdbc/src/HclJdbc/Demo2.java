package HclJdbc;

import java.sql.*;

public class Demo2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hcldriver","root","root");
		Statement stmt=con.createStatement();
		
		
//	 ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from hcl");
//	 while(rs.next())
//	 {
//	 String id=rs.getString("id");
//	 String name=rs.getString("name");
//	 System.out.println("USN:"+id+"\tName:"+name);
//	 }
		
		
		
//	 String query1="create table project(pid varchar(30) primary key,pname varchar(30) not null unique,strtDate date,endDate date)";
//	 
//	 int i=stmt.executeUpdate(query1);
//	 if(i==0)
//	 {
//	 System.out.println("Table created Successfully");
//	 }
//	 else
//	 {
//	 System.out.println("Failed to create table");
//	 }
	 
	 
	 
//	 String query2="insert into project values(103, 'sam','2019-05-09','2019-08-16')";
//	 int i=stmt.executeUpdate(query2);
//	 if(i!=0)
//	 {
//	 System.out.println("INSERTED Successfully");
//	 }
//	 else
//	 {
//	 System.out.println("Failed to insert record");
//	 }
	 
	 
	 
	 
//	 String query3="update project set strtDate='2022-06-18'  where pid=102";
//	 int i=stmt.executeUpdate(query3);
//	 if(i!=0)
//	 {
//	 System.out.println("UPDATED Successfully");
//	 }
//	 else
//	 {
//	 System.out.println("Failed to update record");
//	 }
		
		
		
		
	String query4="delete from project where pid=103";
	int i=stmt.executeUpdate(query4);
	if(i!=0)
	{
	System.out.println("DELETED Successfully");
	}
	else
	{
	System.out.println("Failed to delete");
	}

	
	stmt.close();
	con.close();
	}
}
