package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.datalayer.Impl.IDepartmentRepository;
import com.vti.entity.Department;
import com.vti.utils.JdbcConnection;

public class DepartmentRepository implements IDepartmentRepository{

	public List<Department> getListDepartment() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Department> lstDep = new ArrayList<>();
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM department";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("department_id");
				String name = rs.getString("department_name");
				Department d = new Department(id, name);
				lstDep.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs);
		}
		return lstDep;
	}
	
	
	public Department getDepartmentByCol(String arg) throws Exception {
	    Connection con = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    Department d = null;
	    try {
	        con = JdbcConnection.getConnection();
	        String sql;
	        boolean isNumeric = arg.matches("\\d+"); // Check if arg is a number
	        if (isNumeric) {
	            sql = "SELECT * FROM department WHERE department_id = ?";
	            psmt = con.prepareStatement(sql);
	            psmt.setInt(1, Integer.parseInt(arg));
	        } else {
	            sql = "SELECT * FROM department WHERE department_name = ?";
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1, arg);
	        }

	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("department_id");
	            String depName = rs.getString("department_name");
	            d = new Department(id, depName);
	        }
	    } catch (SQLException e) {
	        throw new Exception("Database error: " + e.getMessage(), e);
	    } catch (NumberFormatException e) {
	        throw new Exception("Invalid department ID: " + arg, e);
	    } finally {
	        JdbcConnection.closeConnection(con, psmt, rs);
	    }
	    return d;
	}


	public boolean insertDepartment(String depName) throws Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean result = false;
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO department (department_name) VALUES (?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, depName);
			int count = psmt.executeUpdate();
			if (count > 0) {
				con.commit();
				result = true;
			} 
		} catch (Exception e) {
			con.rollback();
			throw new Exception("Insert error...!!!");
		} finally {
			JdbcConnection.closeConnection(con, psmt, null);
		}
		return result;
	}
	
	public boolean updateName(int idTemp, String newName) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean res = false;
		try {
			con = JdbcConnection.getConnection();
			String sql = "UPDATE department SET department_name = ? WHERE department_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, newName);
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
	
	public boolean deleteDepartmentById(int id) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		boolean res = false;
		try {
			con = JdbcConnection.getConnection();;
			String sql = "DELETE FROM department WHERE department_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
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
