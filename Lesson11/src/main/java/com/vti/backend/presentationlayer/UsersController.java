package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UsersService;
import com.vti.backend.businesslayer.Impl.IUsersService;
import com.vti.backend.datalayer.UsersRepository;
import com.vti.entity.Department;
import com.vti.entity.Users;

public class UsersController {
	
	public IUsersService iUsersService;
	
	public UsersController() {
		iUsersService = new UsersService();
	}
	
	public boolean login(String username, String password) throws SQLException {
		if (password.length() < 6) {
			System.out.println("Password must more than 6 characters !\n");
			return false;
		}
		return iUsersService.login(username, password);
	}

	public List<Users> getListUser() throws SQLException {
		return iUsersService.getListUser();
	}
	
	public boolean insertUser(String username, String password, int departmentId) throws Exception {
		if (password.length() < 6) {
			System.out.println("Password must more than 6 characters !\n");
			return false;
		}
		return iUsersService.insertUser(username, password, departmentId);
	}
	
	public boolean updatePassword(int idTemp, String newPass) throws SQLException {
		if (newPass.length() < 6) {
			System.out.println("Password must more than 6 characters !\n");
			return false;
		}
		return iUsersService.updatePassword(idTemp, newPass);
	}
	
	public boolean deleteUserById(int id) throws SQLException {
		return iUsersService.deleteUserById(id);
	}
}
