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
	
	public boolean insertDepartment(String depName) throws Exception {
		if(iDepartmentRepository.getDepartmentByCol(depName) != null) {
			System.out.println("Department name has existed !");
			return false;
		}
		return iDepartmentRepository.insertDepartment(depName);
	}
	
	public Department getDepartmentByCol(String arg) throws Exception {
		return iDepartmentRepository.getDepartmentByCol(arg);
	}
	
	public boolean updateName(int idTemp, String newName) throws Exception {
		if(iDepartmentRepository.getDepartmentByCol(String.valueOf(idTemp)) != null) {
			return iDepartmentRepository.updateName(idTemp, newName);
		} else {
			System.out.println("Non_existed department !");
			return false;
		}
		
	}
	
	public boolean deleteDepartmentById(int id) throws Exception {
		if(iDepartmentRepository.getDepartmentByCol(String.valueOf(id)) != null) {
			return iDepartmentRepository.deleteDepartmentById(id);
		} else {
			System.out.println("Non_existed department !");
			return false;
		}
	}
}
