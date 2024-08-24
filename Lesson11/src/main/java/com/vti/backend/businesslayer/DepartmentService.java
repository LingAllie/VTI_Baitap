package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.Impl.IDepartmentService;
import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.Impl.IDepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService{
	
	public IDepartmentRepository iDepartmentRepository;
	
	public DepartmentService() {
		iDepartmentRepository = new DepartmentRepository();
	}

	public List<Department> getListDepartment() throws SQLException {
		return iDepartmentRepository.getListDepartment();
	}
	
	public boolean insertDepartment(int depId, String depName) throws SQLException {
		if(iDepartmentRepository.checkDepartmentName(depName)) {
			System.out.println("Department name has existed !");
			return false;
		}
		return iDepartmentRepository.insertDepartment(depId, depName);
	}
	
	public Department getDepartment(int idTemp) throws SQLException {
		return iDepartmentRepository.getDepartment(idTemp);
	}
	
	public boolean updateName(int idTemp, String newName) throws SQLException {
		return iDepartmentRepository.updateName(idTemp, newName);
	}
	
	public boolean deleteDepartmentById(int id) throws SQLException {
		return iDepartmentRepository.deleteDepartmentById(id);
	}
}
