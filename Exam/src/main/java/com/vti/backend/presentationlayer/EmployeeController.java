/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.EmployeeService;
import com.vti.backend.businesslayer.Impl.IEmployeeService;
import com.vti.entity.Employee;

/**
 * 
 */
public class EmployeeController {

    IEmployeeService iEmployeeService = new EmployeeService();

    public boolean login(String username, String password) throws SQLException {
        return iEmployeeService.login(username, password);
    }

	public boolean insertEmployee(int id, String name, String password, int posId) throws SQLException, Exception {
        if (password.length() <= 6) {
            System.err.println("Password must more than 6 characters !");
        } else {
            return iEmployeeService.insertEmployee(id, name, password, posId);
        }
        return false;
    }
	
	public Employee findEmployee(String arg) throws SQLException {
        return iEmployeeService.findEmployee(arg);
    }

	public boolean updateEmployee(int eId, String newInfo) throws SQLException {
        return iEmployeeService.updateEmployee(eId, newInfo);
    }
	
	public boolean deleteEmployee(int eId) throws SQLException {
        return iEmployeeService.deleteEmployee(eId);
    }
	
	public List<Employee> viewListEmployee() throws SQLException {
        return iEmployeeService.viewListEmployee();
    }

}
