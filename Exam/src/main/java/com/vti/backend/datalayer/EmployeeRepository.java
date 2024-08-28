/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.datalayer;

import java.sql.*;
import java.util.*;

import com.vti.backend.datalayer.Impl.IEmployeeRepository;
import com.vti.backend.datalayer.Impl.IPositionRepository;
import com.vti.entity.Employee;
import com.vti.utils.JdbcConnection;

/**
 * 
 */
public class EmployeeRepository implements IEmployeeRepository{

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	IPositionRepository iPositionRepository = new PositionRepository();
	
	@Override
	public boolean insertEmployee(int id, String name, String password, int posId) throws Exception {
		
		try {
			con = JdbcConnection.getConnection();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO employee (e_id, e_username, e_password, p_id) VALUES (?, ?, ?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setString(3, password);
			psmt.setInt(4, posId);
			
			int count = psmt.executeUpdate();
			if (count > 0) {
				con.commit();
				return true;
			}
			
		} catch (Exception e) {
			con.rollback();
            e.printStackTrace();
            throw new Exception("System insert error !" + e.getMessage(), e);
		} finally {
			JdbcConnection.closeConnection(con, psmt, null, null);
		}
		return false;
	}

	@Override
	public Employee findEmployee(String arg) throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
			
			boolean isNumeric = arg.matches("\\d+");
			String sql;
			if (isNumeric) {
				sql = "SELECT * FROM employee WHERE e = ?";
				psmt = con.prepareStatement(sql);
				psmt.setInt(1, Integer.parseInt(arg));
			} else {
				sql = "SELECT * FROM employee WHERE e_username = ?";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, arg);
			}
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				return new Employee(
					rs.getInt("e_id"), 
					rs.getString("e_username"), 
					rs.getString("e_password"), 
					iPositionRepository.getPosInfor(String.valueOf(rs.getInt("p_id")))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		
		return null;
	}

	@Override
	public boolean updateEmployee(int eId, String newInfo) throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "UPDATE employee SET e_password = ? WHERE e_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, newInfo);
			psmt.setInt(2, eId);

			int count = psmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int eId) throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "DELETE FROM employee WHERE e_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, eId);

			int count = psmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return false;
	}

	@Override
	public List<Employee> viewListEmployee() throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM employee";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			List<Employee> empList = new ArrayList<>();
			while(rs.next()) {
				empList.add(
					new Employee(
						rs.getInt("e_id"), 
						rs.getString("e_username"), 
						rs.getString("e_password"), 
						iPositionRepository.getPosInfor(String.valueOf(rs.getInt("p_id")))
					)
				);
			}
			if (!empList.isEmpty()) {
				return empList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return null;
	}

	@Override
	public boolean login(String username, String password) throws SQLException {
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM employee WHERE e_username = ? AND e_password = ?";
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
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return false;
	}

}
