package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.UsersService;
import com.vti.backend.datalayer.UsersRepository;
import com.vti.entity.Department;
import com.vti.entity.Users;

public class UsersController {

	public static List<Users> getListUser() throws SQLException {
		return UsersService.getListUser();
	}
	
	public static boolean insertUser(int id, String username, String password, int departmentId) throws SQLException {
		return UsersService.insertUser(id, username, password, departmentId);
	}
	
	public static boolean updatePassword(int idTemp, String newPass) throws SQLException {
		return UsersService.updatePassword(idTemp, newPass);
	}
	
	public static boolean deleteUserById(int id) throws SQLException {
		return UsersService.deleteUserById(id);
	}
}
