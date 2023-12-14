package vn.iotstar.Service.Users;

import java.util.List;

import vn.iotstar.Entity.Users;

public interface IUsersService {
	void login(String User, String Pass);

	void checkAccountExist(String User);

	void signup(Users signup);

	void updateUser(Users updateuser);

	List<Users> getAllUsers();

	Users findByUserId(int userid);

	void deleteUser(int UserID) throws Exception;

	List<Users> getdAllUsers(int page, int pagesize);

	Users findByUsername(String username);

	void deleteUser(String Username) throws Exception;

	Users findByEmail(String email);

	String resetCustomerPassword(String email);
}
