package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {

	public abstract List<Department> getListDepartment() throws SQLException;
	
	public abstract boolean insertDepartment(int depId, String depName) throws SQLException;
	
	public abstract Department getDepartment(int idTemp) throws SQLException;
	
	public abstract boolean updateName(int idTemp, String newName) throws SQLException;
	
	public abstract boolean deleteDepartmentById(int id) throws SQLException;
}
