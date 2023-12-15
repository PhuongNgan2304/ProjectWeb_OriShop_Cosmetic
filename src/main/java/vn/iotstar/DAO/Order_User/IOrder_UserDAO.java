package vn.iotstar.DAO.Order_User;

import java.util.List;

import vn.iotstar.Entity.Order_User;

public interface IOrder_UserDAO {
	void insertOrder_User (Order_User order_user);
	List<Order_User> findAllOrderUser();
	float revenuebyYear(int year);
	float revenuebyMonth(int month);
	int countOrder();

}
