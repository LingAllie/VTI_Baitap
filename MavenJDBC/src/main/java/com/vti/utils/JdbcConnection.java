package com.vti.utils;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

	public static Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		Properties pr = new Properties();
		pr.load(new FileInputStream(new File("src\\main\\resource\\database.properties")));
		String url = pr.getProperty("url");
		String username = pr.getProperty("username");
		String password = pr.getProperty("password");
		
		Connection connection;
		connection = DriverManager.getConnection(url, username, password);

		if (connection != null) {
			System.out.println("Connection work !\n");
		} else {
			System.err.println("Connection fail !");
		}
		return connection;
	}

	public static void closeConnection(Connection connection, PreparedStatement pstmt, ResultSet rs)
			throws SQLException {

		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}

	}

}
