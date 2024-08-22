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

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		while (true) {
			menu();
			System.out.print("Please choose a service: ");
			int req = ScannerUtils.inputInt();

			switch (req) {
			case 1:
				int dId = ScannerUtils.inputId("Nhập department id: ");
				String name = ScannerUtils.inputName("Nhâp department name: ");
				DepartmentController.insertDepartment(dId, name);
				break;
				
			case 2:
				int uId = ScannerUtils.inputId("Nhập user id: ");
				String username = ScannerUtils.inputName("Nhập username: ");
				String password = ScannerUtils.inputName("Nhập password: ");
				int departmentId = ScannerUtils.inputId("Nhập department id: ");
				if (DepartmentController.getDepartment(departmentId) != null) {
					UsersController.insertUser(uId, username, password, departmentId);
				} else {
					System.out.println("Không tìm thấy department tương ứng !");
				}
				break;
				
			case 3:
				int uIdTemp = ScannerUtils.inputId("Nhập user id cần đổi pass: ");
				String newPass = ScannerUtils.inputName("Nhập password mới: ");
				UsersController.updatePassword(uIdTemp, newPass);
				break;
				
			case 4:
				int dIdTemp = ScannerUtils.inputId("Nhập department id cần đổi tên: ");
				String newName = ScannerUtils.inputName("Nhập tên mới: ");
				DepartmentController.updateName(dIdTemp, newName);
				break;
				
			case 5:
				int uIdTmp = ScannerUtils.inputId("Nhập user id cần xóa: ");
				UsersController.deleteUserById(uIdTmp);
				break;
				
			case 6:
				int dIdTmp = ScannerUtils.inputId("Nhập department id cần xóa: ");
				DepartmentController.deleteDepartmentById(dIdTmp);
				break;
				
			case 7:
				List<Users> lstU = UsersController.getListUser();
				for (Users u : lstU) {
					System.out.println(u.toString());
				}
				break;
				
			case 8:
				List<Department> lstD = DepartmentController.getListDepartment();
				for (Department d : lstD) {
					System.out.println(d.toString());
				}
				break;
				
			case 9:
				System.out.println("Exit program...");
				return;
				
			default:
				System.out.print("Invalid service's option !!!");
				break;
			}
		}

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
		System.out.println("9. Exit");
		System.out.println("\n //---------- ~.~ -----------//");

	}
}
