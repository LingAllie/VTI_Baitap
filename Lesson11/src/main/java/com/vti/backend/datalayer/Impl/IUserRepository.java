package com.vti.backend.datalayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Users;

public interface IUserRepository {
	
	public abstract boolean login(String username, String password) throws SQLException;

	public abstract List<Users> getListUsers() throws SQLException;
	
	public abstract boolean insertUser(int id, String username, String password, int departmentId) throws SQLException;
	
	public abstract boolean updatePassword(int idTemp, String newPass) throws SQLException;
	
	public abstract boolean deleteUserById(int id) throws SQLException;

	public abstract boolean checkUsername(String username) throws SQLException;

	public abstract boolean checkNewPass(String newPass) throws SQLException;
}
