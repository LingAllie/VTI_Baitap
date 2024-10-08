package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Users;
import com.vti.utils.JdbcConnection;
import com.vti.utils.ScannerUtils;

public class Services {
	public static List<Users> usersList = new ArrayList<>();
	public static List<Department> depsList = new ArrayList<>();
	public static List<Position> possList = new ArrayList<>();
	
	public static List<Users> getUserList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			if (con != null) {
				String sql = "SELECT * FROM users";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int uId = rs.getInt("user_id");
					String username = rs.getString("username");
					Department d = getDepartmentByCol(rs.getInt("department_id"), null);
					Position p = getPositionByCol(rs.getInt("position_id"), null);
					Users user = new Users(uId, username, d, p);
					usersList.add(user);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		
		return usersList;
	}

	
	public static List<Department> getDepartmentList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			if (con != null) {
				String sql = "SELECT * FROM department";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int dId = rs.getInt("department_id");
					String dName = rs.getString("department_name");
					Department dep = new Department(dId, dName);
					depsList.add(dep);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		return depsList;
	}
	
	
	public static List<Position> getPositionList() throws SQLException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			if (con != null) {
				String sql = "SELECT * FROM `position`";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int pId = rs.getInt("position_id");
					String pName = rs.getString("position_name");
					Position pos = new Position(pId, pName);
					possList.add(pos);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		return possList;
	}
	
	
  	public static boolean checkDB(String sql, String msg, String col) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			con = JdbcConnection.getConnection();
			
			if (con != null) {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int quantity = rs.getInt(col);
					if (quantity > 0) {
						flag = true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, rs);
		}
		
		if (!flag) {
			System.out.println(msg);
			return false;
		} else {
			return true;
		}
	}
	
	
	public static Department getDepartmentByCol(int depIdTemp, String depNameTemp) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department department = null;
		try {
			con = JdbcConnection.getConnection();
			if ((depIdTemp != 0 && depNameTemp == null) || (depIdTemp != 0 && depNameTemp != null)) {
				String sql = "SELECT * FROM department WHERE department_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, depIdTemp);
				rs = pstmt.executeQuery();
				boolean flag = false;
				while(rs.next()) {
					flag = true;
					String depName = rs.getString("department_name");
					department = new Department(depIdTemp, depName);
				}
				if (!flag) {
					System.out.println("No department has id = " + depIdTemp);
				}
			} else if ((depIdTemp == 0 && depNameTemp != null) || (depIdTemp != 0 && depNameTemp != null)) {
				String sql = "SELECT * FROM department WHERE department_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, depNameTemp);
				rs = pstmt.executeQuery();
				boolean flag = false;
				while(rs.next()) {
					flag = true;
					int depId = rs.getInt("department_id");
					department = new Department(depId, depNameTemp);
				}
				if (!flag) {
					System.out.println("No department has name = " + depNameTemp);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		
		return department;
	}

	
	public static Position getPositionByCol(int posIdTemp, String posNameTemp) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Position position = null;
		try {
			con = JdbcConnection.getConnection();
			if ((posIdTemp != 0 && posNameTemp == null) || (posIdTemp != 0 && posNameTemp != null)) {
				String sql = "SELECT * FROM `position` WHERE position_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, posIdTemp);
				rs = pstmt.executeQuery();
				boolean flag = false;
				while(rs.next()) {
					flag = true;
					String posName = rs.getString("position_name");
					position = new Position(posIdTemp, posName);
				}
				
				if (!flag) {
					System.out.println("No position has id = " + posIdTemp);
				}
			} else if ((posIdTemp == 0 && posNameTemp != null) || (posIdTemp != 0 && posNameTemp != null)) {
				String sql = "SELECT * FROM `position` WHERE position_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, posNameTemp);
				rs = pstmt.executeQuery();
				boolean flag = false;
				while(rs.next()) {
					flag = true;
					int posId = rs.getInt("position_id");
					position = new Position(posId, posNameTemp);
				}
				
				if (!flag) {
					System.out.println("No position has name = " + posNameTemp);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		
		return position;
	}
	
	
	public static int getUserId() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			con = JdbcConnection.getConnection();
			String sql = "SELECT COUNT(*) AS user_quantity FROM users";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				id = rs.getInt("user_quantity");
			}
			if (!flag) {
				System.out.println("No user found !");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
		
		return id;
		
	}

	
	public static void insertDepartment() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcConnection.getConnection();
			
			if (con != null) {
				boolean replay = true;
				while(replay) {
					System.out.print("Input department name: ");
					String depName = ScannerUtils.inputString("Department name is empty !");
					
					String sql = 	"INSERT INTO department (department_name)" +
									"VALUES (?)";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, depName);
					
					int count = pstmt.executeUpdate();
					
					if (count > 0) {
						System.out.println("Insert department successfully !");
						System.out.print("Continue add deparment ? 1: Yes | 2: No... ");
						int res = ScannerUtils.inputInt();
						while (res != 1 && res != 2) {
							System.out.print("Continue add deparment ? 1: Yes | 2: No... ");
							res = ScannerUtils.inputInt();
						}
						switch(res) {
							case 1:
								replay = true;
								break;
							case 2:
								replay = false;
								break;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
	}

	
	public static void insertPosition() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcConnection.getConnection();
			
			if (con != null) {
				boolean replay = true;
				while(replay) {
					String sql = 	"INSERT INTO `position` (position_name)" +
									"VALUES (?)";
					
					System.out.print("Input position name: ");
					String posName = ScannerUtils.inputString("position name is empty !");
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, posName);
					
					int count = pstmt.executeUpdate();
					
					if (count > 0) {
						System.out.println("Insert position successfully !");
						System.out.print("Continue add position ? 1: Yes | 2: No... ");
						int res = ScannerUtils.inputInt();
						while (res != 1 && res != 2) {
							System.out.print("Continue add position ? 1: Yes | 2: No... ");
							res = ScannerUtils.inputInt();
						}
						switch(res) {
							case 1:
								replay = true;
								break;
							case 2:
								replay = false;
								break;
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
	}
	
	
	public static void insertUser() throws SQLException {
		String sql1 = "SELECT COUNT(*) AS dep_quantity FROM department";
		String sql2 = "SELECT COUNT(*) AS pos_quantity FROM `position`";
		boolean s1 = checkDB(sql1, "Department table is empty! Please insert data...", "dep_quantity");
		boolean s2 = checkDB(sql2, "Position table is empty! Please insert data...", "pos_quantity");
		
		if (s1 && s2) {
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean replay = true;
			
			try {
				con = JdbcConnection.getConnection();
				
				if (con != null) {
					while(replay) {
						String sql = 	"INSERT INTO users (username, department_id, position_id)" +
										"VALUES (?, ?, ?)";
						
						System.out.print("Input username: ");
						String username = ScannerUtils.inputString("Username is empty !");
						
						
						if (getDepartmentList().size() > 0) {
							System.out.println("\n\n|------- Department --------|");
							for(Department d: depsList) {
								System.out.println(d.toString());
							}
							System.out.println("|---------- ~.~ -----------|\n\n");
						}
						
						System.out.print("Input department id: ");
						int depId = ScannerUtils.inputInt();
						while(getDepartmentByCol(depId, null) == null) {
							System.out.print("Non-exist departmen! Input department id again: ");
							depId = ScannerUtils.inputInt();
						}
						
						if (getPositionList().size() > 0) {
							System.out.println("\n\n|------- Position --------|");
							for(Position p: possList) {
								System.out.println(p.toString());
							}
							System.out.println("|--------- ~.~ ----------|\n\n");
						}
						
						System.out.print("Input position id: ");
						int posId = ScannerUtils.inputInt();
						while(getPositionByCol(posId, null) == null) {
							System.out.print("Non-exist position! Input position id again: ");
							posId = ScannerUtils.inputInt();
						}
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, username);
						pstmt.setInt(2, depId);
						pstmt.setInt(3, posId);
						
						int count = pstmt.executeUpdate();
						
						if (count > 0) {
							System.out.println("Insert user successfully !");
							
							System.out.print("Continue add user ? 1: Yes | 2: No... ");
							int res = ScannerUtils.inputInt();
							while (res != 1 && res != 2) {
								System.out.print("Continue add user ? 1: Yes | 2: No... ");
								res = ScannerUtils.inputInt();
							}
							switch(res) {
								case 1:
									replay = true;
									break;
								case 2:
									replay = false;
									break;
							}
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				JdbcConnection.closeConnection(con, pstmt, null);
			}
		} else {
			return;
		}
	}

	
	public static void viewUsers() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcConnection.getConnection();
			String sql = 	"SELECT * FROM users " +
							"LEFT JOIN department USING (department_id)" +
							"LEFT JOIN `position` USING (position_id)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				int depId = rs.getInt("department_id");
				String depName = rs.getString("department_name");
				int posId = rs.getInt("position_id");
				String posName = rs.getString("position_name");
				System.out.println(	"\nUser " + userId + ": " + username +
									"\nDepartment id: " + depId + ": " + depName +
									"\nPosition id: " + posId + ": " + posName);
			}
			if (!flag) {
				System.out.println("No user found !");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.closeConnection(con, pstmt, null);
		}
	}
}



/*  package com.vti.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Users;
import com.vti.utils.JdbcConnection;
import com.vti.utils.ScannerUtils;

public class Services {
    public static List<Users> usersList = new ArrayList<>();
    public static List<Department> depsList = new ArrayList<>();
    public static List<Position> possList = new ArrayList<>();

    public static List<Users> getUserList() throws SQLException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Users user = new Users(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    getDepartmentByCol(rs.getInt("department_id"), null),
                    getPositionByCol(rs.getInt("position_id"), null)
                );
                usersList.add(user);
            }
        }
        return usersList;
    }

    public static List<Department> getDepartmentList() throws SQLException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM department");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                depsList.add(new Department(rs.getInt("department_id"), rs.getString("department_name")));
            }
        }
        return depsList;
    }

    public static List<Position> getPositionList() throws SQLException, IOException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `position`");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                possList.add(new Position(rs.getInt("position_id"), rs.getString("position_name")));
            }
        }
        return possList;
    }

    public static boolean checkDB(String sql, String msg, String col) throws SQLException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next() && rs.getInt(col) > 0) {
                return true;
            }
        }
        System.out.println(msg);
        return false;
    }

    public static Department getDepartmentByCol(int depIdTemp, String depNameTemp) throws SQLException {
        String sql = depIdTemp != 0 
            ? "SELECT * FROM department WHERE department_id = ?" 
            : "SELECT * FROM department WHERE department_name = ?";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (depIdTemp != 0) {
                pstmt.setInt(1, depIdTemp);
            } else {
                pstmt.setString(1, depNameTemp);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Department(rs.getInt("department_id"), rs.getString("department_name"));
                }
            }
        }
        System.out.println(depIdTemp != 0 
            ? "No department has id = " + depIdTemp 
            : "No department has name = " + depNameTemp);
        return null;
    }

    public static Position getPositionByCol(int posIdTemp, String posNameTemp) throws SQLException {
        String sql = posIdTemp != 0 
            ? "SELECT * FROM `position` WHERE position_id = ?" 
            : "SELECT * FROM `position` WHERE position_name = ?";
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (posIdTemp != 0) {
                pstmt.setInt(1, posIdTemp);
            } else {
                pstmt.setString(1, posNameTemp);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Position(rs.getInt("position_id"), rs.getString("position_name"));
                }
            }
        }
        System.out.println(posIdTemp != 0 
            ? "No position has id = " + posIdTemp 
            : "No position has name = " + posNameTemp);
        return null;
    }

    public static int getUserId() throws SQLException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) AS user_quantity FROM users");
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("user_quantity");
            }
        }
        System.out.println("No user found !");
        return 0;
    }

    public static void insertDepartment() throws SQLException {
        String sql = "INSERT INTO department (department_name) VALUES (?)";
        executeInsertWithPrompt("Department name", sql);
    }

    public static void insertPosition() throws SQLException {
        String sql = "INSERT INTO `position` (position_name) VALUES (?)";
        executeInsertWithPrompt("Position name", sql);
    }

    public static void insertUser() throws SQLException {
        if (checkDB("SELECT COUNT(*) AS dep_quantity FROM department", 
                    "Department table is empty! Please insert data...", 
                    "dep_quantity") 
            && 
            checkDB("SELECT COUNT(*) AS pos_quantity FROM `position`", 
                    "Position table is empty! Please insert data...", 
                    "pos_quantity")) {

            try (Connection con = JdbcConnection.getConnection();
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (username, department_id, position_id) VALUES (?, ?, ?)")) {

                while (true) {
                    System.out.print("Input username: ");
                    String username = ScannerUtils.inputString("Username is empty !");
                    
                    int depId = getValidatedInputId("department", depsList);
                    int posId = getValidatedInputId("position", possList);

                    pstmt.setString(1, username);
                    pstmt.setInt(2, depId);
                    pstmt.setInt(3, posId);

                    if (pstmt.executeUpdate() > 0) {
                        System.out.println("Insert user successfully !");
                        if (!promptContinue("Continue add user?")) break;
                    }
                }
            }
        }
    }

    private static void executeInsertWithPrompt(String prompt, String sql) throws SQLException {
        try (Connection con = JdbcConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            while (true) {
                System.out.print("Input " + prompt + ": ");
                String inputValue = ScannerUtils.inputString(prompt + " is empty!");

                pstmt.setString(1, inputValue);
                if (pstmt.executeUpdate() > 0) {
                    System.out.println("Insert " + prompt.toLowerCase() + " successfully!");
                    if (!promptContinue("Continue add " + prompt.toLowerCase() + "?")) break;
                }
            }
        }
    }

    private static int getValidatedInputId(String entity, List<?> list) throws SQLException {
        if (list.isEmpty()) return -1;

        list.forEach(System.out::println);
        System.out.print("Input " + entity + " id: ");
        int id = ScannerUtils.inputInt();
        while (id == 0) {
            System.out.print("Non-existent " + entity + "! Input " + entity + " id again: ");
            id = ScannerUtils.inputInt();
        }
        return id;
    }

    private static boolean promptContinue(String message) throws SQLException {
        System.out.print(message + " 1: Yes | 2: No... ");
        int res = ScannerUtils.inputInt();
        while (res != 1 && res != 2) {
            System.out.print(message + " 1: Yes | 2: No... ");
            res = ScannerUtils.inputInt();
        }
        return res == 1;
    }
}
*/
