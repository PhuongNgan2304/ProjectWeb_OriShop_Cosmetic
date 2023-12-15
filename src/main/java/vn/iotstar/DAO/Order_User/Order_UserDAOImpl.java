package vn.iotstar.DAO.Order_User;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
	@Override
	public float revenuebyMonth(int month) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT SUM(o.total) FROM Order_User o WHERE MONTH(o.orderdate) = :month";
		Query query = enma.createQuery(jpql);
		query.setParameter("month", month);
		 Number result = (Number) query.getSingleResult();
		    float floatValue = (result != null) ? result.floatValue() : 0.0f;
		    return floatValue;
	}
	@Override
	public float revenuebyYear(int year) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT SUM(o.total) FROM Order_User o WHERE YEAR(o.orderdate) = :year";
		Query query = enma.createQuery(jpql);
		query.setParameter("year", year);
		 Number result = (Number) query.getSingleResult();
		    float floatValue = (result != null) ? result.floatValue() : 0.0f;
		    return floatValue;
	}
	@Override
	public int countOrder() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Order_User> query = enma.createNamedQuery("Order_User.findAllOrder_User", Order_User.class);
		List<Order_User> listOrder=query.getResultList();
		return listOrder.size();
	}
}
