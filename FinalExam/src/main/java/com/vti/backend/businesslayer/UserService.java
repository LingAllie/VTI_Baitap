/**
 * @author: Linh
 * @date: Aug 30, 2024
 * 
 */
package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.Impl.IUserService;
import com.vti.backend.datalayer.UserRepository;
import com.vti.backend.datalayer.Impl.IUserRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;

/**
 * 
 */
public class UserService implements IUserService {

    IUserRepository iManagerRepository = new UserRepository();

    @Override
    public List<Employee> viewListEmployeeByProjectId(int pId) {
        try {
            if (iManagerRepository.checkProjectIdExist(pId)) {
                List<Employee> employeeList = iManagerRepository.viewListEmployeeByProjectId(pId);
                if (employeeList != null && !employeeList.isEmpty()) {
                    return employeeList;
                } else {
                    System.out.println("List of employee in project " + pId + " is empty !");
                    return null;
                }
            } else {
                System.out.println("Project " + pId + " does not exist !");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching the employee list.");
            e.printStackTrace(); 
            return null;
        }
    }

    @Override
    public List<Manager> viewListManagerOfEachProject() {
        try {
            List<Manager> managerList = iManagerRepository.viewListManagerOfEachProject();
            if (managerList != null && !managerList.isEmpty()) {
                return managerList;
            } else {
                System.out.println("No project ! No manager !");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching the manager list.");
            e.printStackTrace(); 
            return null;
        }
    }

    @Override
    public boolean Login(String email, String password) {
        try {
            return iManagerRepository.Login(email, password);
        } catch (SQLException e) {
            System.out.println("An error occurred while attempting to log in.");
            e.printStackTrace(); 
            return false;
        }
    }
}
