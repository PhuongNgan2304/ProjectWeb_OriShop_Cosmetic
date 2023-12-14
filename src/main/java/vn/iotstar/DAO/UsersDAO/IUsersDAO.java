package vn.iotstar.DAO.UsersDAO;

import java.util.List;

import vn.iotstar.Entity.Users;

public interface IUsersDAO {

	Users checkAccountExist(String user);

	void SignUp(Users signup);

	Users login(String user, String pass);

	Users findByUserId(int userid);

	void UpdateUser(Users user);

	List<Users> findAll(int page, int pagesize);

	List<Users> findAll();

	Users findByUserName(String username);

	void DeleteUser(String username);

	void DeleteUser(int userid);

	Users findByEmail(String email);

}
