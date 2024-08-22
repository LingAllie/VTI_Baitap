package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.entity.Department;

public class DepartmentController {

	public static List<Department> getListDepartment() throws SQLException {
		return DepartmentService.getListDepartment();
	}
	
	public static boolean insertDepartment(int depId, String depName) throws SQLException {
		return DepartmentService.insertDepartment(depId, depName);
	}
	
	public static Department getDepartment(int idTemp) throws SQLException {
		return DepartmentService.getDepartment(idTemp);
	}
	
	public static boolean updateName(int idTemp, String newName) throws SQLException{
		return DepartmentService.updateName(idTemp, newName);
	}
	
	public static boolean deleteDepartmentById(int id) throws SQLException {
		return DepartmentService.deleteDepartmentById(id);
	}
}
