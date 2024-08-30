/**
 * @author: Linh
 * @update: Aug 30, 2024
 * 
 */
package com.vti.backend.datalayer.Impl;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;


public interface IUserRepository {

    public abstract List<Employee> viewListEmployeeByProjectId(int pId) throws SQLException;

    public abstract List<Manager> viewListManagerOfEachProject() throws SQLException;
    
    public abstract boolean Login(String email, String password) throws SQLException;
    
    public abstract boolean checkProjectIdExist(int pId) throws SQLException;
    
}
