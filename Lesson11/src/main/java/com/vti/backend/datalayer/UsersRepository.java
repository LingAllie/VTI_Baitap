package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Users;
import com.vti.utils.JdbcConnection;

public class UsersRepository {

	public static List<Users> getListUsers() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Users> lstUser = new ArrayList<>();
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM users";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int depId = rs.getInt("department_id");
				Users u = new Users(id, username, password, DepartmentRepository.getDepartment(depId));
				lstUser.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs);
		}
		return lstUser;
	}
	
	public static boolean insertUser(int id, String username, String password, int departmentId) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean result = false;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, username);
			psmt.setString(3, password);
			psmt.setInt(4, departmentId);
			int count = psmt.executeUpdate();
			if (count > 0) {
				con.commit();
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			JdbcConnection.closeConnection(con, psmt, null);
		}
		return result;
	}
	
	public static boolean updatePassword(int idTemp, String newPass) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean res = false;
		try {
			con = JdbcConnection.getConnection();
			String sql = "UPDATE users SET password = ? WHERE user_id = " + idTemp;
			psmt = con.prepareStatement(sql);
			psmt.setString(1, newPass);
			int count = psmt.executeUpdate();
			if (count > 0) {
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, null);
		}
		return res;
	}
	
	public static boolean deleteUserById(int id) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean res = false;
		try {
			con = JdbcConnection.getConnection();
			String sql = "DELETE FROM users WHERE user_id = " + id;
			psmt = con.prepareStatement(sql);
			int count = psmt.executeUpdate();
			if (count > 0) {
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, null);
		}
		return res;
	}
	
	
}
