package vn.iotstar.DAO.Order_User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Order_User;
import vn.iotstar.JPAConfig.JPAConfig;

public class Order_UserDAOImpl implements IOrder_UserDAO{

	@Override
	public void insertOrder_User(Order_User order_user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(order_user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public List<Order_User> findAllOrderUser() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Order_User> query = enma.createNamedQuery("Order_User.findAllOrder_User", Order_User.class);
		return query.getResultList();
	}

}
