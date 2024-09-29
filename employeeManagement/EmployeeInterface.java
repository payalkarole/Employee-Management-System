package com.employeeManagement;

public interface EmployeeInterface {
	
	public void addEmployee(Employee e);
	public void deleteEmployee(int id);
	public void updateEmployee(int id);
	public Employee searchEmployeeById(int id);
	public void displayAllEmployees();
	
}
