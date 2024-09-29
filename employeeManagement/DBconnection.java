package com.employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/employeedb";
	public static final String USERNAME="root";
	public static final String PASSWORD="K$26k";
	
	static Connection con=null;
	
	public static Connection getConnect()
	{
		try {
			// register/load the driver
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver loaded");
			
			// get the connection
			con=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connection established");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		getConnect();
	}
}
