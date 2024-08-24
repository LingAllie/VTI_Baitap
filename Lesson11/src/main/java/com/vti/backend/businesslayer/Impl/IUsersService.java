package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Users;

public interface IUsersService {
	
	public abstract boolean login(String username, String password) throws SQLException;

	public abstract List<Users> getListUser() throws SQLException;
	
	public abstract boolean insertUser(int id, String username, String password, int departmentId) throws SQLException;
	
	public abstract boolean updatePassword(int idTemp, String newPass) throws SQLException;
	
	public abstract boolean deleteUserById(int id) throws SQLException;
	
}
