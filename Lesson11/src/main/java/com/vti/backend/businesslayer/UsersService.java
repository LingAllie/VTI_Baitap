package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.UsersRepository;
import com.vti.backend.datalayer.Impl.IUserRepository;
import com.vti.backend.businesslayer.Impl.IUsersService;
import com.vti.entity.Users;

public class UsersService implements IUsersService {
    public static IUserRepository iUserRepository;

    public UsersService() {
        iUserRepository = new UsersRepository();
    }

    public List<Users> getListUser() throws SQLException {
        return iUserRepository.getListUsers();
    }

    public boolean insertUser(String username, String password, int departmentId) throws Exception {
        if(iUserRepository.getUserByCol(username) != null) {
        	System.out.println("Username has existed !");
        	return false;
        }
     
    	return iUserRepository.insertUser(username, password, departmentId);
    }

    public Users getUserByCol(String arg) throws SQLException, Exception {
    	if (iUserRepository.getUserByCol(arg) == null) {
    		System.out.println("User does not exist !");
    		return null;
    	}
    	return iUserRepository.getUserByCol(arg);
    }
    
    public boolean updatePassword(int idTemp, String newPass) throws Exception {
    	if (iUserRepository.getUserByCol(String.valueOf(idTemp)) == null) {
    		System.out.println("User does not exist to update !");
    		return false;
    	} else if(iUserRepository.getUserByCol(newPass) != null) {
    		System.out.println("The new password is similar to the old password !");
    		return false;
    	}
    	
        return iUserRepository.updatePassword(idTemp, newPass);
    }

    public boolean deleteUserById(int id) throws Exception {
    	if (iUserRepository.getUserByCol(String.valueOf(id)) == null) {
    		System.out.println("User does not exist to delete !");
    		return false;
    	}
        return iUserRepository.deleteUserById(id);
    }

	@Override
	public boolean login(String username, String password) throws SQLException {
		return iUserRepository.login(username, password);
	}
}

