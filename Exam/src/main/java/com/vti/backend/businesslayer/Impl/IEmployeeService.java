/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;

/**
 * 
 */
public interface IEmployeeService {

    public abstract boolean login(String username, String password) throws SQLException;

	public abstract boolean insertEmployee(int id, String name, String password, int posId) throws SQLException, Exception;
	
	public abstract Employee findEmployee(String arg) throws SQLException;

	public abstract boolean updateEmployee(int eId, String newInfo) throws SQLException;
	
	public abstract boolean deleteEmployee(int eId) throws SQLException;
	
	public abstract List<Employee> viewListEmployee() throws SQLException;

}
