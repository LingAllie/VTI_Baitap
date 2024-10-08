package com.vti.frontend;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.vti.utils.JdbcConnection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, FileNotFoundException, IOException 
    {
//    	viewUserById(2);
    	
    	System.out.println("=========== 1 ===========");
    	Connection con = JdbcConnection.getConnection();
    	String sql = "{CALL getListAllUser()}";
    	CallableStatement call = con.prepareCall(sql);
    	ResultSet rs = call.executeQuery();
    	while(rs.next()) {
    	    System.out.println("username:" + rs.getString("username"));
    	}
    	JdbcConnection.closeConnection(null, null, call, rs);
    	
    	
    	System.out.println("=========== 2 ===========");
    	String sql2 = "{CALL GetListUserById(?)}";
    	CallableStatement call2 = con.prepareCall(sql2);
    	call2.setInt(1, 3);
    	ResultSet rs2 = call2.executeQuery();
    	while(rs2.next()) {
    	    System.out.println("username:" + rs2.getString("username"));
    	}
    	JdbcConnection.closeConnection(null, null, call2, rs2);
    	
    	
    	System.out.println("=========== 3 ===========");
    	String sql3 = "{CALL updateUserById(?, ?)}";
    	CallableStatement call3 = con.prepareCall(sql3);
    	call3.setInt(1, 2);
    	call3.setString(2, "Yin");
    	int count = call3.executeUpdate();
    	if (count > 0) {
    		System.out.println("Update ok");
    	}
    	
    	
    	JdbcConnection.closeConnection(con, null, call3, null);

    	
    }
    
    public static void viewUserById(int idTmp) throws SQLException, FileNotFoundException, IOException {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        connection = JdbcConnection.getConnection();
	        String sql = "select * from users where user_id = ?";
	        pstmt = connection.prepareStatement(sql);
	        pstmt.setInt(1, idTmp);
	        rs = pstmt.executeQuery();
	        boolean flag = false;
	        while (rs.next()) {
	        	flag = true;
	        	int id = rs.getInt("user_id");
                String us = rs.getString("username");
//                String pass = rs.getString("password");
	        	System.out.println("User: " + id + " " + us );
	        }
	        if (!flag) {
	        	System.out.println("Khong tim thay user !");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JdbcConnection.closeConnection(connection, pstmt, null, rs);
	    }
	}
	
	public static void viewUserById2(int id, String name) {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        con = JdbcConnection.getConnection();
	        String sql = "select * from users where id = ? and username = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, name);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int id1 = rs.getInt("id");
	            String us = rs.getString("username");
	            System.out.println("User:" + id1 + " " + us);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void insertUser(String username, String password, int departmentId, int positionId) throws SQLException {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    try {
	        con = JdbcConnection.getConnection();
	        String sql = "insert into users (username, password, department_id, position_id) values (?, ?, ?, ?)";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        pstmt.setInt(3, departmentId);
	        pstmt.setInt(4, positionId);
	        int count = pstmt.executeUpdate();
	        if (count > 0) {
	            System.out.println("Thêm mới thành công");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JdbcConnection.closeConnection(con, pstmt, null, null);
	    }
	}
	
	public static void updateUser(int id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "Update users Set password = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Update thanh cong !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null, null);
		}
	}

	public static void deleteUser(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcConnection.getConnection();
			String sql = "Delete from users Where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("Xoa user thanh cong !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null, null);
		}
	}
	

}

