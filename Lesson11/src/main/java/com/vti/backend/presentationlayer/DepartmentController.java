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
		if(iDepartmentService.getListDepartment().size() > 0) {
			return iDepartmentService.getListDepartment();
		} else {
			System.out.println("List is empty !");
			return null;
		}
	}
	
	public boolean insertDepartment(String depName) throws Exception {
		return iDepartmentService.insertDepartment(depName);
	}
	
	public Department getDepartmentByCol(String arg) throws Exception {
		return iDepartmentService.getDepartmentByCol(arg);
	}
	
	public boolean updateName(int idTemp, String newName) throws Exception{
		return iDepartmentService.updateName(idTemp, newName);
	}
	
	public boolean deleteDepartmentById(int id) throws Exception {
		return iDepartmentService.deleteDepartmentById(id);
	}
}
