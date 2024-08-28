/**
 * @author: Linh
 * @date: Aug 26, 2024
 * 
 */
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.Impl.IEmployeeService;
import com.vti.backend.datalayer.EmployeeRepository;
import com.vti.backend.datalayer.PositionRepository;
import com.vti.backend.datalayer.Impl.IEmployeeRepository;
import com.vti.backend.datalayer.Impl.IPositionRepository;
import com.vti.entity.Employee;

/**
 * 
 */
public class EmployeeService implements IEmployeeService{

    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    IPositionRepository iPositionRepository = new PositionRepository();

    @Override
    public boolean login(String username, String password) throws SQLException {
        return iEmployeeRepository.login(username, password);
    }

    @Override
    public boolean insertEmployee(int id, String name, String password, int posId) throws SQLException, Exception {
        if (iPositionRepository.viewListPosition() == null) {
            System.out.println("Position table is empty, please insert data for position first !");
            return false;
        }
        if (iEmployeeRepository.findEmployee(name) == null) {
            return iEmployeeRepository.insertEmployee(id, name, password, posId);
        } 
        return false;
    }

    @Override
    public Employee findEmployee(String arg) throws SQLException {
        try {
            return iEmployeeRepository.findEmployee(arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateEmployee(int eId, String newInfo) throws SQLException {
        return iEmployeeRepository.updateEmployee(eId, newInfo);
    }

    @Override
    public boolean deleteEmployee(int eId) throws SQLException {
        return iEmployeeRepository.deleteEmployee(eId);
    }

    @Override
    public List<Employee> viewListEmployee() throws SQLException {
        try {
            return iEmployeeRepository.viewListEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
