/**
 * @author: Linh
 * @date: Aug 30, 2024
 * 
 */
package com.vti.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.utils.ScannerUtils;


public class App {
    public static UserController userController = new UserController();

    public static void main(String[] args) {
        while (true) {
            menuBeforeLogin();
            
            int req1 = ScannerUtils.inputNumInt("Your choice: ");
            
            switch(req1) {
                case 1:
                    boolean loginStatus = login();
                    while (loginStatus) {
                        try {
                            menuAfterLogin();

                            int req = ScannerUtils.inputNumInt("Please choose a service: ");

                            switch (req) {
                                case 1:
                                    int pId = ScannerUtils.inputNumInt("Please enter projectId: ");
                                    try {
                                    	System.out.println("\nProject " + pId);
                                        List<Employee> listEmployee = userController.viewListEmployeeByProjectId(pId);
                                        if (listEmployee != null && !listEmployee.isEmpty()) {
                                            for (Employee e : listEmployee) {
                                                System.out.println(e.toString());
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("An error occurred while fetching employees. Please try again later.");
                                        e.printStackTrace(); 
                                    }
                                    break;

                                case 2:
                                    try {
                                        List<Manager> listManager = userController.viewListManagerOfEachProject();
                                        if (listManager != null && !listManager.isEmpty()) {
                                            for (Manager m : listManager) {
                                            	System.out.println("\nProject " + m.getProjectId());
                                                System.out.println(m.toString());
                                            }
                                        } else {
                                            System.out.println("No managers found.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("An error occurred while fetching managers. Please try again later.");
                                        e.printStackTrace(); 
                                    }
                                    break;

                                case 3:
                                    loginStatus = false;
                                    System.out.println("Log out successfully !\n");
                                    break;

                                default:
                                    System.out.println("Invalid service's option !!!");
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("An unexpected error occurred. Please try again later.");
                            e.printStackTrace(); 
                        }
                    }
                    break;

                case 2:
                    System.out.println("Exit program !");
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    break;
            }
        }
    }

    private static boolean login() {
        System.out.println("Login");
        String username = ScannerUtils.inputString("Enter email: ");
        String password = ScannerUtils.inputString("Enter password: ");
        
        try {
            if (userController.Login(username, password)) {
                System.out.println("Log in successfully !\n");
                return true;
            } else {
                System.out.println("Invalid email or password.\n");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while logging in. Please try again later.");
            e.printStackTrace(); 
            return false;
        }
    }
    
    public static void menuBeforeLogin() {
        System.out.println("\n\n //---------- Welcome -----------//");
        System.out.println("1. Login for manage");
        System.out.println("2. Exit program");
        System.out.println("\n //---------- ~.~ -----------//");
    }
    
    private static void menuAfterLogin() {
        System.out.println("\nProgram is running ~");
        System.out.println("1. View list of employee in project by project ID");
        System.out.println("2. View Manager of all projects");
        System.out.println("3. Logout account");
        System.out.println("<3 <3 <3 <3 <3 <3 <3 <3 <3\n");
    }
}