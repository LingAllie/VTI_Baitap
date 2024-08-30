/**
 * @author: Linh
 * @date: Aug 30, 2024
 * 
 */
package com.vti.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import com.vti.backend.businesslayer.UserService;
import com.vti.backend.businesslayer.Impl.IUserService;
import com.vti.entity.Employee;
import com.vti.entity.Manager;

public class UserController {

    IUserService iManagerService = new UserService();

    public List<Employee> viewListEmployeeByProjectId(int pId) {
        try {
            return iManagerService.viewListEmployeeByProjectId(pId);
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching the employee list.");
            e.printStackTrace(); 
            return null;
        }
    }

    public List<Manager> viewListManagerOfEachProject() {
        try {
            return iManagerService.viewListManagerOfEachProject();
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching the manager list.");
            e.printStackTrace(); 
            return null;
        }
    }
    
    public boolean Login(String email, String password) {
        if (Pattern.matches("^[a-zA-Z0-9._%+-]+@vti\\.com\\.vn$", email) && password.length() >= 6 && password.length() <= 12) {
            try {
                return iManagerService.Login(email, password);
            } catch (SQLException e) {
                System.out.println("An error occurred during login.");
                e.printStackTrace(); 
                return false;
            }
        }
        System.out.println("Email is not correct format or password's length must be from 6 to 12 characters!");
        return false;
    }
}
