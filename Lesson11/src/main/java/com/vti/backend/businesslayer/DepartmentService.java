package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService {

	public static List<Department> getListDepartment() throws SQLException {
		return DepartmentRepository.getListDepartment();
	}
	
	public static boolean insertDepartment(int depId, String depName) throws SQLException {
		return DepartmentRepository.insertDepartment(depId, depName);
	}
	
	public static Department getDepartment(int idTemp) throws SQLException {
		return DepartmentRepository.getDepartment(idTemp);
	}
	
	public static boolean updateName(int idTemp, String newName) throws SQLException{
		return DepartmentRepository.updateName(idTemp, newName);
	}
	
	public static boolean deleteDepartmentById(int id) throws SQLException {
		return DepartmentRepository.deleteDepartmentById(id);
	}
}
