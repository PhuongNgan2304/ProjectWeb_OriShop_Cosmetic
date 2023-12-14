package vn.iotstar.Service.Users;

import vn.iotstar.DAO.UsersDAO.UsersDAO_Impl;
import java.util.List;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.RandomStringUtils;

import vn.iotstar.DAO.UsersDAO.IUsersDAO;
import vn.iotstar.Entity.Users;
import vn.iotstar.JPAConfig.JPAConfig;

public class UsersServiceImpl implements IUsersService{
IUsersDAO userDAO=new UsersDAO_Impl();
	
	@Override
	public void login(String User, String Pass)
	{
		userDAO.login(User, Pass);
	}
	@Override
	public void signup(Users signup)
	{
		userDAO.SignUp(signup);
	}
	@Override
	public void checkAccountExist(String User)
	{
		userDAO.checkAccountExist(User);
	}
	@Override
	public void updateUser(Users updateuser) {
		userDAO.UpdateUser(updateuser);
	}
	
	@Override
	public void deleteUser(int UserID)  throws Exception{
		userDAO.DeleteUser(UserID);
	}
	@Override
	public void deleteUser(String Username)  throws Exception{
		userDAO.DeleteUser(Username);
	}
	
	@Override
	public List<Users> getAllUsers(){
        return userDAO.findAll();
    }
	@Override
	public Users findByUserId(int userid) {
		return userDAO.findByUserId(userid);
	}
	@Override
	public Users findByUsername(String username) {
		return userDAO.findByUserName(username);
	}
	@Override
	public Users findByEmail(String email) {
		return userDAO.findByEmail(email);
	}
	@Override
	public List<Users> getdAllUsers(int page, int pagesize) {
		return userDAO.findAll(page, pagesize);
	}
	@Override
	public String resetCustomerPassword(String email) {
        Users user = userDAO.findByEmail(email);
         
        String randomPassword = RandomStringUtils.randomAlphanumeric(10);
         
        user.setPassword(randomPassword);
        userDAO.UpdateUser(user);
         
        return randomPassword;
    }
}
