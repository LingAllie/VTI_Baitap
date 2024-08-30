/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.businesslayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;

/**
 * 
 */
public interface IUserService {

	public abstract List<Employee> viewListEmployeeByProjectId(int pId) throws SQLException;

    public abstract List<Manager> viewListManagerOfEachProject() throws SQLException;
    
    public abstract boolean Login(String email, String password) throws SQLException;
}
