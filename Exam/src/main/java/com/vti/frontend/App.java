package com.vti.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.EmployeeController;
import com.vti.backend.presentationlayer.PositionController;
import com.vti.entity.Employee;
import com.vti.entity.Position;
import com.vti.utils.ScannerUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static EmployeeController employeeController = new EmployeeController();
	public static PositionController positionController = new PositionController();

	public static void main(String[] args) throws Exception {
		while (true) {
			menuBeforeLogin();
			
			int req1 = ScannerUtils.inputNumInt("Your choice: ");
			
			switch(req1) {
			case 1:
				boolean loginStatus = login();
				while (loginStatus)
					try {
						
						menuAfterLogin();

						int req = ScannerUtils.inputNumInt("Please choose a service: ");

						switch (req) {
						case 1:
							int pId = ScannerUtils.inputNumInt("Input position id: ");
							String pName = ScannerUtils.inputString("Input position name: ");
							if (positionController.insertPosition(pId, pName)) {
								System.out.println("Insert position success !");
							} else {
								System.err.println("Insert position failed !");
							}
							
							break;

						case 2:
							int eId = ScannerUtils.inputNumInt("Input employee's id: ");
							String username = ScannerUtils.inputString("Input username: ");
							String password = ScannerUtils.inputString("Input password: ");
							pId = ScannerUtils.inputNumInt("Input position's id: ");
							
							if (employeeController.insertEmployee(eId, username, password, pId)) {
								System.out.println("New employee's account has been created !");
							} else {
								System.err.println("Create new employee's account failed !");
							}

							break;

						case 3:
							String arg = ScannerUtils.inputString("Input name of id of employee: ");
							if (employeeController.findEmployee(arg) != null) {
								System.out.println(employeeController.findEmployee(arg).toString());
							} else {
								System.err.println("Cannot find employee with id / name = " + arg);
							}
							break;

						case 4:
							arg = ScannerUtils.inputString("Input name of id of position: ");
							if (positionController.getPosInfor(arg) != null) {
								System.out.println(positionController.getPosInfor(arg).toString());
							} else {
								System.err.println("Cannot find position with id / name = " + arg);
							}
							break;

						case 5:
							eId = ScannerUtils.inputNumInt("Input employee's id need update password: ");
							String newPass = ScannerUtils.inputString("Input new password: ");
							if (employeeController.updateEmployee(eId, newPass)) {
								System.out.println("Update success !");
							} else {
								System.err.println("Update failed !");
							}
							break;

						case 6:
							pId = ScannerUtils.inputNumInt("Input employee's id need update password: ");
							String newName = ScannerUtils.inputString("Input new department name: ");
							if (positionController.updatePosById(pId, newName)) {
								System.out.println("Update success !");
							} else {
								System.err.println("Update failed !");
							}
							break;

						case 7:
							eId = ScannerUtils.inputNumInt("Input employee's id need delete: ");
							if (employeeController.deleteEmployee(eId)) {
								System.out.println("Delete success !");
							} else {
								System.err.println("Delete failed !");
							}
							break;

						case 8:
							pId = ScannerUtils.inputNumInt("Input employee's id need delete: ");
							if (positionController.deletePosById(pId)) {
								System.out.println("Delete success !");
							} else {
								System.err.println("Delete failed !");
							}
							break;
							
						case 9:
							List<Employee> empList = employeeController.viewListEmployee();
							if (!empList.isEmpty()) {
								for(Employee e: empList) {
									System.out.println(e.toString());
								}
							}
							break;
						
						case 10:
							List<Position> posList = positionController.viewListPosition();
							if (!posList.isEmpty()) {
								for(Position p: posList) {
									System.out.println(p.toString());
								}
							}
							break;
							
						case 11:
							loginStatus = false;
							System.out.println("Log out successfully !\n");
							break;

						default:
							System.out.print("Invalid service's option !!!");
							break;

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
				break;
				
			case 2:
				while(true) {
					int eId = ScannerUtils.inputNumInt("Input employee's id: ");
					String username = ScannerUtils.inputString("Input username: ");
					String password = ScannerUtils.inputString("Input password: ");
					int pId = ScannerUtils.inputNumInt("Input position's id: ");
					
					if (employeeController.insertEmployee(eId, username, password, pId)) {
						System.out.println("New employee's account has been created !");
						break;
					} else {
						System.err.println("Create new employee's account failed !");
					}
				}
				
				break;
				
			case 3:
				System.out.println("Exit program !");
				return;
				
			}

		}

	}

	private static boolean login() throws SQLException {
		System.out.println("Login");
		String username = ScannerUtils.inputString("Enter username: ");
		String password = ScannerUtils.inputString("Enter password: ");

		if (employeeController.login(username, password)) {
			System.out.println("Log in successfully !\n");
			return employeeController.login(username, password);
		}
		return false;
	}
	
	
	public static void menuBeforeLogin() {
		System.out.println("\n\n //---------- Welcome -----------//");
		System.out.println("1. Login");
		System.out.println("2. Create new account");
		System.out.println("3. Exit program");
		System.out.println("\n //---------- ~.~ -----------//");

	}
	

	private static void menuAfterLogin() {
		System.out.println("\nProgram is running ~");
		System.out.println("1.Insert new position");
		System.out.println("2.Insert new employee");
		System.out.println("3.Find employee info by id/name");
		System.out.println("4.Find position info by id/name");
		System.out.println("5.Update employee by id");
		System.out.println("6.Update position by id");
		System.out.println("7.Delete employee by id");
		System.out.println("8.Delete position by id");
		System.out.println("9.View list of employee (All / by Position)");
		System.out.println("10.View list of position");
		System.out.println("11.Logout account");
		System.out.println("<3 <3 <3 <3 <3 <3 <3 <3 <3\n");
	}

}
