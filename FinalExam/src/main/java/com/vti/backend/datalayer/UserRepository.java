/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.vti.backend.datalayer.Impl.IUserRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.utils.JdbcConnection;

/**
 * 
 */
public class UserRepository implements IUserRepository{

    private static Connection con = null;
    private static PreparedStatement psmt = null;
    private static ResultSet rs = null;
    
	@Override
	public List<Employee> viewListEmployeeByProjectId(int pId) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		List<Employee> listEmp = new ArrayList<>();
		
		try {
			
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM `user` WHERE project_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, pId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				listEmp.add(new Employee(
											rs.getInt("id"),
											rs.getString("full_name"),
											rs.getString("email"),
											rs.getString("password"),
											rs.getString("pro_skill"),
											rs.getInt("project_id")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return listEmp;
	}
	
	@Override
	public List<Manager> viewListManagerOfEachProject() throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		List<Manager> listManager = new ArrayList<>();
		
		try {
			
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM `user` " +
                    "WHERE role = 'Manager' AND project_id IN (SELECT DISTINCT project_id FROM `user` WHERE role = 'Manager')";
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				listManager.add(new Manager(
											rs.getInt("id"),
											rs.getString("full_name"),
											rs.getString("email"),
											rs.getString("password"),
											rs.getInt("exp_in_year"),
											rs.getInt("project_id")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, psmt, rs, null);
		}
		return listManager;
	}

	@Override
	public boolean Login(String email, String password) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		List<Manager> listManager = new ArrayList<>();
		
		try {
			
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM `user` WHERE email = ? AND password = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
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

	@Override
	public boolean checkProjectIdExist(int pId) throws SQLException {
		Connection con = null;
		PreparedStatement psmt = null;
		List<Manager> listManager = new ArrayList<>();
		
		try {
			
			con = JdbcConnection.getConnection();
			String sql = "SELECT * FROM `user` WHERE project_id = ?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, pId);
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
