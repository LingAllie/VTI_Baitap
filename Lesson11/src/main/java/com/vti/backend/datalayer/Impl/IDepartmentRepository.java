package com.vti.backend.datalayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	public abstract List<Department> getListDepartment() throws SQLException;
	
	public abstract Department getDepartmentByCol(String arg) throws SQLException, Exception;
	
	public abstract boolean insertDepartment(String depName) throws SQLException, Exception;
	
	public abstract boolean updateName(int idTemp, String newName) throws SQLException;
	
	public abstract boolean deleteDepartmentById(int id) throws SQLException;
	
}
