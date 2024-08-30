/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.utils;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 
 */
public class JdbcConnection {

	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Properties pr = new Properties();
		pr.load(new FileInputStream(new File("src\\main\\resource\\database.properties")));
		String url = pr.getProperty("url");
		String username = pr.getProperty("username");
		String password = pr.getProperty("password");
		
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("DB Connecting...");
		} else {
			System.out.println("Cannot connect...!");
		}
		return con;
	}
	
	public static void closeConnection(Connection con, PreparedStatement psmt, ResultSet rs, CallableStatement call) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (psmt != null) {
			psmt.close();
		}
		if (call != null) {
			call.close();
		}
		if (con != null && !con.isClosed()) {
			con.close();
		}
	}
}
