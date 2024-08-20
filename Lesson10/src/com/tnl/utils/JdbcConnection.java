package com.tnl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static Connection getConnection(String dbName) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		String username = "root";
		String password = "root";

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
