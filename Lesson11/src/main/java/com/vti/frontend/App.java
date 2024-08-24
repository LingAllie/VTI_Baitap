package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.Services;
import com.vti.backend.presentationlayer.DepartmentController;
import com.vti.backend.presentationlayer.UsersController;
import com.vti.entity.Department;
import com.vti.entity.Users;
import com.vti.utils.JdbcConnection;
import com.vti.utils.ScannerUtils;



public class App {

	public static UsersController usersController = new UsersController();
	public static DepartmentController departmentController = new DepartmentController();
	
	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		while(true) {
			boolean loginStatus = login();
			while (loginStatus)
				try {
					
						menu();
						
						System.out.print("Please choose a service: ");
						int req = ScannerUtils.inputInt();

						switch (req) {
						case 1:
							int dId = ScannerUtils.inputId("Nhập department id: ");
							String name = ScannerUtils.inputName("Nhâp department name: ");
							if (departmentController.insertDepartment(dId, name)) {
								System.out.println("Insert department successfully !");
							}
							break;
							
						case 2:
							int uId = ScannerUtils.inputId("Nhập user id: ");
							String username = ScannerUtils.inputName("Nhập username: ");
							String password = ScannerUtils.inputName("Nhập password: ");
							int departmentId = ScannerUtils.inputId("Nhập department id: ");
							try {
								if (departmentController.getDepartment(departmentId) != null) {
									if (usersController.insertUser(uId, username, password, departmentId)) {
										System.out.println("Insert user successfully !");
									}
								} else {
									System.out.println("Không tìm thấy department tương ứng !");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							break;
							
						case 3:
							int uIdTemp = ScannerUtils.inputId("Nhập user id cần đổi pass: ");
							String newPass = ScannerUtils.inputName("Nhập password mới: ");
							if (usersController.updatePassword(uIdTemp, newPass)) {
								System.out.println("Update password successfully !");
							}
							break;
							
						case 4:
							int dIdTemp = ScannerUtils.inputId("Nhập department id cần đổi tên: ");
							String newName = ScannerUtils.inputName("Nhập tên mới: ");
							if (departmentController.updateName(dIdTemp, newName)) {
								System.out.println("Update department name successfully !");
							}
							break;
							
						case 5:
							int uIdTmp = ScannerUtils.inputId("Nhập user id cần xóa: ");
							if (usersController.deleteUserById(uIdTmp)) {
								System.out.println("Delete user successfully !");
							}
							break;
							
						case 6:
							int dIdTmp = ScannerUtils.inputId("Nhập department id cần xóa: ");
							if (departmentController.deleteDepartmentById(dIdTmp)) {
								System.out.println("Delete department successfully !");
							}
							break;
							
						case 7:
							List<Users> lstU = usersController.getListUser();
							for (Users u : lstU) {
								System.out.println(u.toString());
							}
							break;
							
						case 8:
							List<Department> lstD = departmentController.getListDepartment();
							for (Department d : lstD) {
								System.out.println(d.toString());
							}
							break;
							
						case 9:
							loginStatus = false;
							System.out.println("Log out successfully !\n");
							break;
							
						default:
							System.out.print("Invalid service's option !!!");
							break;
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	
	private static boolean login() throws SQLException {
		System.out.println("Welcome to program ! First login your account: ");
		String username = ScannerUtils.inputName("Enter username: ");
		String password = ScannerUtils.inputName("Enter password: ");
		
		if (usersController.login(username, password)) {
			System.out.println("Log in successfully !\n");
		}
		return usersController.login(username, password);
	}


	public static void menu() {
		System.out.println("\n\n //---------- Menu -----------//");
		System.out.println("1. Insert Department");
		System.out.println("2. Insert User");
		System.out.println("3. Update password by user id");
		System.out.println("4. Update Department name by id");
		System.out.println("5. Delete User by id");
		System.out.println("6. Delete Department by id");
		System.out.println("7. View list of Users");
		System.out.println("8. View list of Departments");
		System.out.println("9. Log out");
		System.out.println("\n //---------- ~.~ -----------//");

	}
}
