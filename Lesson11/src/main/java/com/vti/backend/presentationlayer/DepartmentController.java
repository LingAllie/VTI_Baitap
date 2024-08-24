package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.Impl.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	
	public IDepartmentService iDepartmentService;
	
	public DepartmentController() {
		iDepartmentService = new DepartmentService();
	}

	public List<Department> getListDepartment() throws SQLException {
		return iDepartmentService.getListDepartment();
	}
	
	public boolean insertDepartment(int depId, String depName) throws SQLException {
		return iDepartmentService.insertDepartment(depId, depName);
	}
	
	public Department getDepartment(int idTemp) throws SQLException {
		return iDepartmentService.getDepartment(idTemp);
	}
	
	public boolean updateName(int idTemp, String newName) throws SQLException{
		return iDepartmentService.updateName(idTemp, newName);
	}
	
	public boolean deleteDepartmentById(int id) throws SQLException {
		return iDepartmentService.deleteDepartmentById(id);
	}
}
