package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.Impl.IDepartmentRepository;
import com.vti.backend.datalayer.Impl.IUserRepository;
import com.vti.entity.Department;
import com.vti.entity.Users;
import com.vti.utils.JdbcConnection;

public class UsersRepository implements IUserRepository{
	
	public IDepartmentRepository iDepartmentRepository;
	
	public UsersRepository() {
		iDepartmentRepository = new DepartmentRepository();
	}

	public List<Users> getListUsers() throws SQLException {
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
				Users u = new Users(id, username, password, iDepartmentRepository.getDepartmentByCol(String.valueOf(depId)));
				lstUser.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs);
		}
		return lstUser;
	}
	
	public boolean insertUser(String username, String password, int departmentId) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean result = false;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO users (username, password, department_id) VALUES (?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			psmt.setInt(3, departmentId);
			int count = psmt.executeUpdate();
			if (count > 0) {
				con.commit();
				result = true;
			}
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Insert error... !!!");
		} finally {
			JdbcConnection.closeConnection(con, psmt, null);
		}
		return result;
	}
	
	public boolean updatePassword(int idTemp, String newPass) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean res = false;
		try {
			con = JdbcConnection.getConnection();
			String sql = "UPDATE users SET password = ? WHERE user_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, newPass);
			psmt.setInt(2, idTemp);
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
	
	public boolean deleteUserById(int id) throws SQLException {
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


	@Override
	public boolean login(String username, String password) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs);
		}
		
		System.out.println("Username or password incorrect ! Please try again !");
		return false;
	}

	@Override
	public Users getUserByCol(String arg) throws Exception {
	    Connection con = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    Users u = null;
	    try {
	        con = JdbcConnection.getConnection();
	        String sql;
	        boolean isNumeric = arg.matches("\\d+"); // Check if arg is a number
	        if (isNumeric) {
	            sql = "SELECT * FROM users WHERE user_id = ?";
	            psmt = con.prepareStatement(sql);
	            psmt.setInt(1, Integer.parseInt(arg));
	        } else {
	            sql = "SELECT * FROM users WHERE username = ? OR password = ?";
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1, arg);
	            psmt.setString(2, arg);
	        }

	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("user_id");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            int depId = rs.getInt("department_id");

	            u = new Users(id, username, password, iDepartmentRepository.getDepartmentByCol(String.valueOf(depId)));
	        }
	    } catch (SQLException e) {
	        throw new Exception("Database error: " + e.getMessage(), e);
	    } catch (NumberFormatException e) {
	        throw new Exception("Invalid user ID: " + arg, e);
	    } finally {
	        JdbcConnection.closeConnection(con, psmt, rs);
	    }
	    return u;
	}

	
	
}
