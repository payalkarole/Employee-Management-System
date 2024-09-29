package com.employeeManagement;

public class Employee {

	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private double phone_no;
	private String hire_date;
	private float salary;
	
	
	public Employee() {
		super();
		
	}
	public Employee(int employee_id, String first_name,String last_name, String email, double phone_no, String hire_date,float salary) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_no = phone_no;
		this.hire_date = hire_date;
		this.salary = salary;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(double phone_no) {
		this.phone_no = phone_no;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone_no=" + phone_no + ", hire_date=" + hire_date + ", salary=" + salary
				+ "]";
	}

}
