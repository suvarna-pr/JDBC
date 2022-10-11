package JDBCdemo;

public class Employee {
	private int empid;
	private String empname;
	private String empadd;
	private String salary;
	
	public Employee(int empid, String empname, String empadd, String salary) 
	{
		super();
		this.empid = empid;
		this.empname = empname;
		this.empadd = empadd;
		this.salary = salary;
	}
	public Employee() {
		
	}
	
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	
	public String getEmpadd() {
		return empadd;
	}
	public void setEmpadd(String empadd) {
		this.empadd = empadd;
	}
	
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
