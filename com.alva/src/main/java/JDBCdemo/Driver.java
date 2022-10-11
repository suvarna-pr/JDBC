package JDBCdemo;
import java.sql.*;
import java.util.Scanner;
public class Driver {
		public static void insertEmp(Employee e) throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1,e.getEmpid());
			ps.setString(2,e.getEmpname());
			ps.setString(3,e.getEmpadd());
			ps.setString(4,e.getSalary());
			ps.execute();
			con.close();
	
		}
		public static void deleteEmp(int empid) throws ClassNotFoundException, SQLException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
			ps.setInt(1, empid);
			ps.execute();
			con.close();	
		}
		
		public static void update(int id,Employee e) throws ClassNotFoundException, SQLException
		{
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps=con.prepareStatement("update employee set empname=?,empadd=? where empid=?");
			ps.setString(1,e.getEmpname());
			ps.setString(2,e.getEmpadd());
			ps.setInt(3,e.getEmpid());
			ps.execute();
			con.close();
		}
		public static void view(Employee e) throws ClassNotFoundException, SQLException {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			Statement smt= con.createStatement();
			ResultSet rs=smt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			smt.close();
			con.close();

		}
		public static void byid(int empid) throws ClassNotFoundException, SQLException
		{
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps=con.prepareStatement("select *from employee where empid=?");
			ps.setInt(1,empid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			ps.close();
			con.close();
		}
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Scanner s=new Scanner(System.in);
			boolean exit=true;
			while(exit) {
				System.out.println("Enter your choice");
				int ch=s.nextInt();
				switch(ch)
				{
				case 1:System.out.println("Enter the employee ID");
						int empid=s.nextInt();
						System.out.println("Enter the employee Name");
						String empname=s.next();
						System.out.println("Enter the employee Address");
						String empadd=s.next();
						System.out.println("Enter the employee salary");
						String salary=s.next();
						Employee e=new Employee();
						e.setEmpid(empid);
						e.setEmpname(empname);
						e.setEmpadd(empadd);
						e.setSalary(salary);
						insertEmp(e);
						break;
				case 2:System.out.println("Enter the employee ID");
						int empid1=s.nextInt();
				        deleteEmp(empid1);
				       break;
				   
				case 3: System.out.println("Enter the id");
						int empid2=s.nextInt();
						System.out.println("The updated details");
						String empname2=s.next();
						String empadd2=s.next();
						String salary2=s.next();
						Employee e1=new Employee();
						e1.setEmpid(empid2);
						e1.setEmpname(empname2);
						e1.setEmpadd(empadd2);
						e1.setSalary(salary2);
						update(empid2,e1);
						break;
				case 4:Employee e2=new Employee();
						view(e2);
					   break;
				case 5:System.out.println("Enter the id");
						int empid6=s.nextInt();
						Employee e3=new Employee();
					   byid(empid6);
					   break;
					
				case 6:exit=false;
				break;
				default:System.out.println("Please enter valid input");
				}
			}
				
		}
		
}
