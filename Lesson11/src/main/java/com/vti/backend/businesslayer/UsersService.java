package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.UsersRepository;
import com.vti.entity.Department;
import com.vti.entity.Users;

public class UsersService {

	public static List<Users> getListUser() throws SQLException {
		return UsersRepository.getListUsers();
	}
	
	public static boolean insertUser(int id, String username, String password, int departmentId) throws SQLException {
		return UsersRepository.insertUser(id, username, password, departmentId);
	}
	
	public static boolean updatePassword(int idTemp, String newPass) throws SQLException {
		return UsersRepository.updatePassword(idTemp, newPass);
	}
	
	public static boolean deleteUserById(int id) throws SQLException {
		return UsersRepository.deleteUserById(id);
	}
}
