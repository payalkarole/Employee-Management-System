package com.employeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeImpl implements EmployeeInterface{
	
	Connection con;
	 Statement st;
	 ResultSet rs;
	 PreparedStatement pst;
	
	 
	static Scanner sc= new Scanner(System.in);
	
	public EmployeeImpl() {
		con= DBconnection.getConnect();
		System.out.println("Connection established");
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	public void addEmployee(Employee e) {
		try {
			pst= con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			pst.setInt(1, e.getEmployee_id());
			pst.setString(2, e.getFirst_name());
			pst.setString(3, e.getLast_name());
			pst.setString(4, e.getEmail());
			pst.setDouble(5, e.getPhone_no());
			pst.setString(6, e.getHire_date());
			pst.setFloat(7, e.getSalary());
			
			
			int noOfrowsInserted=pst.executeUpdate();
			if(noOfrowsInserted>0)
			{
				System.out.println("Employee added...");
			}
			else
			{
				System.out.println("Error in adding the employee");
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	
	public void deleteEmployee(int id) {
		try {
			
		 int noOfRowsDeleted=st.executeUpdate("delete from employee where employee_id="+id);
		  if(noOfRowsDeleted>0)
		  {
			  System.out.println("employee "+id+" is deleted");
		  }
		  else
		  {
			  System.out.println("Error in deleting employee");
		  }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void updateEmployee(int id) {
		try
		{
			 Employee e= searchEmployeeById(id);
		   if(e!=null)
		   {
			  System.out.println(e);
			  System.out.println("Enter new Salary:");
			  float salary= sc.nextFloat();
			    pst= con.prepareStatement("update employee set salary=? where employee_id=?");
				pst.setFloat(1, salary);
				pst.setInt(2, id);
				
				int noOfRowsUpdated=pst.executeUpdate();
				if(noOfRowsUpdated>0)
				{
					System.out.println("Employee updated");
					System.out.println(searchEmployeeById(id));
				}
				else
				{
					System.out.println("Error in updating the Employee...");
				}
			   
	    	}
		   else
		   {
			   System.out.println("Employee not found...");
		   }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public Employee searchEmployeeById(int id) {
		try {
			pst= con.prepareStatement("select * from employee where employee_id=?");
			pst.setInt(1, id);
			
			rs=pst.executeQuery();
			while(rs.next())
			{
				Employee e= new Employee();
				e.setEmployee_id(rs.getInt(1));
				e.setFirst_name(rs.getString(2));
				e.setLast_name(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setPhone_no(rs.getDouble(5));
				e.setHire_date(rs.getString(6));
				e.setSalary(rs.getFloat(7));
				
				return e;	
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	
	public void displayAllEmployees() {
		try {
			rs=st.executeQuery("select * from employee");
		
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5)+" "+rs.getString(6)+" "+rs.getFloat(7));
				
			}
			
			  System.out.println("+------------------+----------------------+----------------+--------------------+--------------------+-------------------+-------------------+");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
