package com.employeeManagement;

import java.util.Scanner;

public class EmployeeApp {
	
static Scanner sc = new Scanner(System.in);
	
	public static void menu()
	{
		System.out.println("1. Add a employee");
		System.out.println("2. Delete employee");
		System.out.println("3. Update employee salary");
		System.out.println("4. Search employee by id");
		System.out.println("5. Display all employees");
		System.out.println("0. Exit");
		
	}
	
	public static void main(String[] args) {
		
		int ch;
		char choice;
		EmployeeInterface eint= new EmployeeImpl();
		Employee e;
		do
		{
			menu();
			System.out.println("enter your choice:");
			ch= sc.nextInt();
			switch(ch)
			{
			case 1:e= new Employee();
			       System.out.println("Enter employee id:");
			       e.setEmployee_id(sc.nextInt());
			       System.out.println("Enter the first name:");
			       e.setFirst_name(sc.next());
			       System.out.println("Enter the last name:");
			       e.setLast_name(sc.next());
			       System.out.println("Enter email:");
		           e.setEmail(sc.next());
		           System.out.println("Enter Phone no:");
		           e.setPhone_no(sc.nextDouble());
		           System.out.println("Enter Hire_date:");
		           e.setHire_date(sc.next());
			       System.out.println("Enter Salary:");
			       e.setSalary(sc.nextFloat());
			        
			        eint.addEmployee(e);
				  break;
			case 2: System.out.println("Enter the employee id to be deleted");
			        int employee_id= sc.nextInt();
			        eint.deleteEmployee(employee_id);
				  break;
			case 3: System.out.println("Enter the employee id to be updated:");
			      employee_id= sc.nextInt();
			       eint.updateEmployee(employee_id);
			       
				break;
			case 4: System.out.println("Enter the employee id to be searched");
			         employee_id= sc.nextInt();
	                 e=eint.searchEmployeeById(employee_id);
	                 if(e!=null)
	                	 System.out.println(e);
	                 else
	                    System.out.println("Employee not found");
						  break;
			case 5:eint.displayAllEmployees();
				   break;
			case 6:System.out.println("------Employee App Exit---------------"); 
				  System.exit(0);
			        break;
			  default: System.out.println("Error in input");      
			}
			
			System.out.println("Do you want to perform more operation(y/n)");
			choice= sc.next().charAt(0);
		}while(choice =='Y'|| choice=='y');
		System.out.println("------Employee App Exit---------------"); 
	}

}
