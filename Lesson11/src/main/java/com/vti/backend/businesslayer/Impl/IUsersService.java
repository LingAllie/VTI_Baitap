package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Users;

public interface IUsersService {
	
	public abstract boolean login(String username, String password) throws SQLException;

	public abstract List<Users> getListUser() throws SQLException;
	
	public abstract boolean insertUser(String username, String password, int departmentId) throws SQLException, Exception;
	
	public abstract Users getUserByCol(String arg) throws SQLException, Exception;
	
	public abstract boolean updatePassword(int idTemp, String newPass) throws SQLException, Exception;
	
	public abstract boolean deleteUserById(int id) throws SQLException, Exception;
	
}
