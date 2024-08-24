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

    public boolean insertUser(int id, String username, String password, int departmentId) throws SQLException {
        if(iUserRepository.checkUsername(username)) {
        	System.out.println("Username has existed !");
        	return false;
        }
     
    	return iUserRepository.insertUser(id, username, password, departmentId);
    }

    public boolean updatePassword(int idTemp, String newPass) throws SQLException {
    	if(iUserRepository.checkNewPass(newPass)) {
    		System.out.println("The new password is similar to the old password !");
    		return false;
    	}
    	
        return iUserRepository.updatePassword(idTemp, newPass);
    }

    public boolean deleteUserById(int id) throws SQLException {
        return iUserRepository.deleteUserById(id);
    }

	@Override
	public boolean login(String username, String password) throws SQLException {
		return iUserRepository.login(username, password);
	}
}

