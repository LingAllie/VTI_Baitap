package com.tnl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/quan_ly_du_an";
		String username = "root";
		String password = "root";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			if (connection != null) {
				System.out.println("Connection work !\n");
				
				Statement st = connection.createStatement();
//				String sql = "INSERT INTO employee (employee_last_name, employee_first_name, employee_hire_date, employee_status, supervisor_id, social_security_number) \r\n"
//						+ "VALUES 	('Son', 'John', '2024-08-16', 1, NULL, 128866789)";
//				
				String sql = "Update employee set employee_last_name = 'Neil' where employee_id = 13";
				int rs = st.executeUpdate(sql);
				
				System.out.println("Insert success ! " + rs);
				
				connection.close();
			} else {
				System.err.println("Connection fail !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
