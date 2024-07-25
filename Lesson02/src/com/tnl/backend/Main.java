package com.tnl.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	
	// Question 5
	public enum Position {
		Dev, Test, ScrumMaster, PM;
	}
	
	
	private static void createAccount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter accountId: ");
		int accId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please enter email: ");
		String email = sc.nextLine();
		
		System.out.println("Please enter username: ");
		String username = sc.nextLine();
		
		System.out.println("Please enter fullName: ");
		String fullName = sc.nextLine();
		
		System.out.println("Please enter department id as 1: `Sales` || 2: `Marketing` || 3: `HR` || 4: `IT` ");
		int departmentId = sc.nextInt();
		sc.nextLine();
		
		Department department = null;
		if (departmentId == 1) {
			department = new Department(1, "Sales");
		} else if (departmentId == 2) {
			department = new Department(2, "Marketing");
		} else if (departmentId == 3) {
			department = new Department(3, "HR");
		} else if (departmentId == 4) {
			department = new Department(3, "IT");
		} else {
			department = null;
		}
		
		System.out.println("Please enter position id as 1: Dev || 2: Test || 3: Scrum Master || 4: PM");
		int position = sc.nextInt();
		
		Position pos;
		switch(position) {
			case 1:
				pos = Position.Dev;
				break;
			case 2:
				pos = Position.Test;
				break;
			case 3:
				pos  = Position.ScrumMaster;
				break;
			case 4:
				pos = Position.PM;
				break;
			default:
				pos = null;
				break;
		}
		
		Account new_acc = new Account(accId, email, username, fullName, department, pos, new Date() );
		System.out.println("Create account successfully !");
	}
	
	
	
	// Question 6

	private static void createDepartment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter departmentId: ");
		int depId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please enter departmentName: ");
		String depName = sc.nextLine();
		
		Department new_dep = new Department(depId, depName);
		System.out.println("Create department successfully !");
	}
	
	// Question 9
	private static void addAccIntoGroup(Account[] accounts, Group[] groups) {
		for(Account a : accounts) {
			System.out.println(a.username);
		}
		System.out.println("\nChoose a specific username: ");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		System.out.println("\n");
		
		for(Group g: groups) {
			System.out.println(g.groupName);
		}
		System.out.println("\nChoose a specific group name: ");
		String groupName = sc.nextLine();
		
		boolean userFound = false;
		boolean groupFound = false;
		Account selectedAccount = null;
		Group selectedGroup = null;
		
		for (Account a : accounts) {
			if(a.username.equals(username)) {
				userFound = true;
				selectedAccount = a;
				break;
			}
		}
		
		for (Group g : groups) {
			if(g.groupName.equals(groupName)) {
				groupFound = true;
				selectedGroup = g;
				break;
			}
		}
		
		if (userFound && groupFound) {
            GroupAccount newGroupAccount = new GroupAccount(selectedGroup, selectedAccount, new Date());
            System.out.println("\nAdd account " + selectedAccount.username + " into group " + selectedGroup.groupName + " successfully !");
        } else if (!userFound) {
        	System.out.println("\nUndefined username !");
        } else if (!groupFound) {
        	System.out.println("\nUndefined groupName !");
        } 
	}
	
	// Question 11
	private static void addAccIntoRandomGroup(Account[] accounts, Group[] groups) {
		for(Account a : accounts) {
			System.out.println(a.username);
		}
		System.out.println("\nChoose a specific username: ");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		System.out.println("\n");
		
		
		boolean userFound = false;
		Account selectedAccount = null;
		Group selectedGroup = null;
		
		for (Account a : accounts) {
			if(a.username.equals(username)) {
				userFound = true;
				selectedAccount = a;
				break;
			}
		}
		Random random = new Random();
		int rand = random.nextInt(groups.length);
		for (int i = 0; i < groups.length; i++) {
			if(i == rand) {
				selectedGroup = groups[i];
				break;
			}
		}
		
		if (userFound) {
            GroupAccount newGroupAccount = new GroupAccount(selectedGroup, selectedAccount, new Date());
            System.out.println("\nAdd account " + selectedAccount.username + " into group " + selectedGroup.groupName + " successfully !");
        } else if (!userFound) {
        	System.out.println("\nUndefined username !");
        }
	}

	
	
	public static void main(String[] args) throws ParseException {

//		DataInitialization.initializeData();

		// Create Departments
		Department sales = new Department(1, "Sales");
		Department marketing = new Department(2, "Marketing");
		Department hr = new Department(3, "HR");
		Department it = new Department(4, "IT");

		// Create Accounts
		Account[] accounts = {
				new Account(1, "john.doe@example.com", "john_doe", "John Doe", sales, Position.Dev, new Date()),
				new Account(2, "jane.smith@example.com", "jane_smith", "Jane Smith", marketing, Position.PM, new Date()),
				new Account(3, "alice.brown@example.com", "alice_brown", "Alice Brown", hr, Position.Test, new Date()),
				new Account(4, "bob.johnson@example.com", "bob_johnson", "Bob Johnson", it, Position.ScrumMaster, new Date())
		};
		
		// Create Groups
		Group[] groups = {
	            new Group(1, "Team A", accounts[0], new Date()),
	            new Group(2, "Team B", accounts[1], new Date()),
	            new Group(3, "Team C", accounts[2], new Date()),
	            new Group(4, "Team D", accounts[3], new Date())
	        };

		// Create GroupAccounts

		GroupAccount[] groupAccount1 = {
				new GroupAccount(groups[0], accounts[0], new Date()),
                new GroupAccount(groups[0], accounts[1], new Date()) };

		GroupAccount[] groupAccount2 = { 
				new GroupAccount(groups[1], accounts[0], new Date()),
                new GroupAccount(groups[1], accounts[1], new Date()),
                new GroupAccount(groups[1], accounts[2], new Date()),
                new GroupAccount(groups[1], accounts[3], new Date())
            };

		GroupAccount[] groupAccount3 = { 
				new GroupAccount(groups[2], accounts[1], new Date()),
                new GroupAccount(groups[2], accounts[2], new Date()),
                new GroupAccount(groups[2], accounts[3], new Date())
            };

		GroupAccount[] groupAccount4 = { new GroupAccount(groups[3], accounts[3], new Date())};


		/* ****************************************** 			   ****************************************** */
		/* ****************************************** Exercise 1: ****************************************** */
		/* ****************************************** 		     ****************************************** */
		
		// Question 1
	/*
		System.out.println("Question 1");
		if (accounts[1].department == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			System.out.println("Phong ban cua nhan vien nay la " + accounts[1].department.departmentName);
		}
	*/

		// Question 2
	/*
		System.out.println("\nQuestion 2");
		List<String> new_gacc = new ArrayList<>();

		for (int i = 0; i < groupAccount1.length; i++) {
			if (groupAccount1[i].account.accountId == accounts[1].accountId) {
				new_gacc.add(groupAccount1[i].group.groupName);
			}
			if (i == (groupAccount1.length - 1)) {
				for (int j = 0; j < groupAccount2.length; j++) {
					if (groupAccount2[j].account.accountId == accounts[1].accountId) {
						new_gacc.add(groupAccount2[j].group.groupName);
					}
					if (j == (groupAccount2.length - 1)) {
						for (int k = 0; k < groupAccount3.length; k++) {
							if (groupAccount3[k].account.accountId == accounts[1].accountId) {
								new_gacc.add(groupAccount3[k].group.groupName);
							}
							if (k == (groupAccount3.length - 1)) {
								for (int l = 0; l < groupAccount4.length; l++) {
									if (groupAccount4[l].account.accountId == accounts[1].accountId) {
										new_gacc.add(groupAccount4[l].group.groupName);
									}
								}
							}
						}
					}
				}
			}
		}
		if (new_gacc.isEmpty()) {
			System.out.println("Nhan vien nay chua co group");
		} else if (new_gacc.size() == 1) {
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0));
		} else if (new_gacc.size() == 2) {
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0) + ", " + new_gacc.get(1));
		} else if (new_gacc.size() == 3) {
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
		} else {
			System.out.println("Nhan vien nay la nguoi hong chuyen, tham gia tat ca cac group");
		}
	*/

		// Question 3
	/*
		System.out.println("\nQuestion 3");
		System.out.println((accounts[1].department == null) ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + accounts[1].department.departmentName);
	*/
		
		// Question 4
	/*
		System.out.println("\nQuestion 4");
		System.out.println(
				(accounts[1].position.name().equals("Dev")) ? "Day la developer" : "Nguoi nay khong phai la Developer");
	*/
		
		// Question 5
	/*
		System.out.println("\nQuestion 5");
		switch (groupAccount1.length) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

		// Question 6
		System.out.println("\nQuestion 6");
		switch (new_gacc.size()) {
		case 0:
			System.out.println("Nhan vien nay chua co group");
			break;
		case 1:
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0));
			break;
		case 2:
			System.out.println("Group cua nhan vien nay la " + new_gacc.get(0) + ", " + new_gacc.get(1));
			break;
		case 3:
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}
	
		// Question 7
		System.out.println("\nQuestion 7");
		switch (accounts[0].position.name()) {
		case "Dev":
			System.out.println("Day la developer");
			break;
		default:
			System.out.println("Nguoi nay khong phai la Developer");
			break;
		}

		// Question 8
		System.out.println("\nQuestion 8");
		Account[] accs = { accounts[0], accounts[1], accounts[2], accounts[3] };
		for (Account a : accs) {
			System.out.println(a.email);
			System.out.println(a.fullName);
			System.out.println(a.department.departmentName);
			System.out.println();
		}

		// Question 9
		System.out.println("\nQuestion 9");
		Department[] deps = { sales, marketing, hr, it };
		for (Department d : deps) {
			System.out.println(d.departmentId);
			System.out.println(d.departmentName);
			System.out.println();
		}

		// Question 10
		System.out.println("\nQuestion 10");
		for (int i = 0; i < accs.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban: " + accs[i].department.departmentName);
			System.out.println();
		}

		// Question 11
		System.out.println("\nQuestion 11");
		for (int i = 0; i < deps.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
		}

		// Question 12
		System.out.println("\nQuestion 12");
		for (int i = 0; i < deps.length; i++) {
			if (i < 2) {
				System.out.println("Thông tin department thứ " + (i + 1) + " là:");
				System.out.println("Id: " + deps[i].departmentId);
				System.out.println("Name: " + deps[i].departmentName);
				System.out.println();
			}
		}

		// Question 13
		System.out.println("\nQuestion 13");
		for (int i = 0; i < accs.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.departmentName);
				System.out.println();
			}
		}

		// Question 14
		System.out.println("\nQuestion 14");
		for (int i = 0; i < accs.length; i++) {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban: " + accs[i].department.departmentName);
				System.out.println();
			}
		}

		// Question 15
		System.out.println("\nQuestion 15");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

		// Question 16
		System.out.println("\nQuestion 16");

		System.out.println("\nQuestion 16.10");
		int i = 0;
		while (i < accs.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.11");
		i = 0;
		while (i < deps.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.12");
		i = 0;
		while (i < deps.length) {
			if (i == 2) {
				break;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.13");
		i = 0;
		while (i < accs.length) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.14");
		i = 0;
		while (i < accs.length) {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban:" + accs[i].department.departmentName);
				System.out.println();
			}
			i++;
		}

		// -----------------------------
		System.out.println("\nQuestion 16.15");
		i = 1;
		while (i <= 20) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}

		// Question 17
		System.out.println("\nQuestion 17");

		System.out.println("\nQuestion 17.10");
		i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.11");
		i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		} while (i < deps.length);

		// -----------------------------
		System.out.println("\nQuestion 17.12");
		i = 0;
		do {
			if (i == 2) {
				break;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].departmentId);
			System.out.println("Name: " + deps[i].departmentName);
			System.out.println();
			i++;
		} while (i < deps.length);

		// -----------------------------
		System.out.println("\nQuestion 17.13");
		i = 0;
		do {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accs[i].email);
			System.out.println("Full name: " + accs[i].fullName);
			System.out.println("Phòng ban:" + accs[i].department.departmentName);
			System.out.println();
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.14");
		i = 0;
		do {
			if (accs[i].accountId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accs[i].email);
				System.out.println("Full name: " + accs[i].fullName);
				System.out.println("Phòng ban:" + accs[i].department.departmentName);
				System.out.println();
			}
			i++;
		} while (i < accs.length);

		// -----------------------------
		System.out.println("\nQuestion 17.15");
		i = 1;
		do {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		} while (i <= 20);

		/* ****************************************** 			   ****************************************** */
		/* ****************************************** Exercise 5: ****************************************** */
		/* ****************************************** 		     ****************************************** */
		
		// Question 1

//		Scanner sc = new Scanner(System.in);
		
	/*
		System.out.println("Please enter 3 integer number: ");
		System.out.println("a = ");
		int a = sc.nextInt();
		System.out.println("b = ");
		int b = sc.nextInt();
		System.out.println("c = ");
		int c = sc.nextInt();
		System.out.println("You have entered 3 numbers: " + a + " " + b + " " + c);
	*/
		
		// Question 2
	/*
		System.out.println("Please enter 3 real number: ");
		System.out.println("a = ");
		float d = sc.nextFloat();
		System.out.println("b = ");
		float e = sc.nextFloat();
		System.out.println("You have entered 2 numbers: " + d + " " + e);
	*/
		
		// Question 3
	/*
		System.out.println("Please enter your first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter your last name: ");
		String lastName = sc.nextLine();
		System.out.println("Your fullname is " + lastName + " " + firstName);
	*/
		
		// Question 4
	/*
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		System.out.println("Please enter your birthday as dd-MM-yyyy: ");
		String date = sc.nextLine();
		Date birth = simpleDateFormat.parse(date);
		System.out.println("Your birthday is " + birth);
	*/
		
		// Question 5
//		createAccount();
		
		// Question 6
//		createDepartment();
		
		// Question 7
	/*
		System.out.println("Please enter an even number: ");
		int eNum = sc.nextInt();
		int count = 3;
		while (count > 1) {
			if (eNum % 2 != 0) {
				--count;
				System.out.println("You have " + count + " times left ! Please enter an even number: ");
				eNum = sc.nextInt();
			} else {
				System.out.println("Your even number is " + eNum);
				break;
			}
			if ((eNum % 2 != 0) && (count == 1)) {
				System.out.println("No more chance ! Please run again !");
				break;
			}
		}
	*/
		
		// Question 8
	/*
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		int req = sc.nextInt();
		
		if (req != 1 && req != 2 && req != 3) {
			while(req != 1 && req != 2 && req != 3) {
				System.out.println("Mời bạn nhập lại !");
				System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
				req = sc.nextInt();
				
				if (req == 1) {
					createAccount();
					break;
				} else if (req == 2) {
					createDepartment();
					break;
				} else if (req == 3) {
					addAccIntoGroup(accounts, groups);
					break;
				}
			}
		} else {
			if (req == 1) {
				createAccount();
			} else if (req == 2) {
				createDepartment();
			} else if (req == 3) {
				addAccIntoGroup(accounts, groups);
			} 
		}
	*/
		
		// Question 9
//		addAccIntoGroup(accounts, groups);
		
		// Question 10
	/*
		boolean isChoose = true;
		while (isChoose) {
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			int req = sc.nextInt();
			sc.nextLine();
			
			if (req != 1 && req != 2 && req != 3) {
				while(req != 1 && req != 2 && req != 3) {
					System.out.println("Mời bạn nhập lại !");
					System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
					req = sc.nextInt();
					sc.nextLine();
					
					
					if (req == 1) {
						createAccount();
						System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
						String choice = sc.nextLine();
						if (choice.equals("Không")) {
							isChoose = false;
							return;
						}
					} else if (req == 2) {
						createDepartment();
						System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
						String choice = sc.nextLine();
						if (choice.equals("Không")) {
							isChoose = false;
							return;
						}
					} else if (req == 3) {
						addAccIntoGroup(accounts, groups);
						System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
						String choice = sc.nextLine();
						if (choice.equals("Không")) {
							isChoose = false;
							return;
						}
					}
				}
			} else {
				if (req == 1) {
					createAccount();
					System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
					String choice = sc.nextLine();
					if (choice.equals("Không")) {
						isChoose = false;
						return;
					}
				} else if (req == 2) {
					createDepartment();
					System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
					String choice = sc.nextLine();
					if (choice.equals("Không")) {
						isChoose = false;
						return;
					}
				} else if (req == 3) {
					addAccIntoGroup(accounts, groups);
					System.out.println("\nBạn có muốn thực hiện chức năng khác không ? Có : Không");
					String choice = sc.nextLine();
					if (choice.equals("Không")) {
						isChoose = false;
						return;
					}
				} 
			}
		}
	*/
		
		// Question 11
	/*
		System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
		int req = sc.nextInt();
		
		if (req != 1 && req != 2 && req != 3 && req != 4) {
			while(req != 1 && req != 2 && req != 3 && req != 4) {
				System.out.println("Mời bạn nhập lại !");
				System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
				req = sc.nextInt();
				
				if (req == 1) {
					createAccount();
					break;
				} else if (req == 2) {
					createDepartment();
					break;
				} else if (req == 3) {
					addAccIntoGroup(accounts, groups);
					break;
				} else if (req == 4) {
					addAccIntoRandomGroup(accounts, groups);
					break;
				}
			}
		} else {
			if (req == 1) {
				createAccount();
			} else if (req == 2) {
				createDepartment();
			} else if (req == 3) {
				addAccIntoGroup(accounts, groups);
			} else if (req == 4) {
				addAccIntoRandomGroup(accounts, groups);
			}
		}
	*/
		
//		sc.close();
		
	}
	
}
