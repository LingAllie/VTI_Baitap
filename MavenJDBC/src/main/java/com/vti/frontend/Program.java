package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vti.utils.JdbcConnection;

public class Program {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			
			System.out.println("=========== 1 ===========");
			String sql = "INSERT INTO department (department_name) VALUES ('Phong bao ve')"; 
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			JdbcConnection.closeConnection(null, pstmt, null, null);
			
			System.out.println("=========== 2 ===========");
			String sql2 = "INSERT INTO users (username, department_id, position_id) VALUES ('Son', 5, 3)"; 
			
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.executeUpdate();
			
			con.commit();
			
			JdbcConnection.closeConnection(con, pstmt2, null, null);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
		} finally {
			JdbcConnection.closeConnection(con, null, null, null);
		}
		
		
	}
}
