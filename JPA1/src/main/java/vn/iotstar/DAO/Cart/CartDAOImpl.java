package vn.iotstar.DAO.Cart;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Cart;
import vn.iotstar.JPAConfig.JPAConfig;

public class CartDAOImpl implements ICartDAO {

	@Override
	public Cart findByCartId(int cartid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Cart cart = enma.find(Cart.class, cartid);
		return cart;
	}

	@Override
	public List<Cart> findCartsByUserId(int userId) {
		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "Select e from Cart e where e.users.UserID =:id ";
		Query query = enma.createQuery(jpql, Cart.class);
		query.setParameter("id", userId);

		List<Cart> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public void insert(Cart cart) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			enma.persist(cart);
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
	public void update(Cart cart) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(cart);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}

	@Override
	public void delete(int cartId) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			Cart new_cart = enma.find(Cart.class, cartId);
			if (new_cart != null) {
				enma.remove(new_cart);
			} else {
				throw new Exception("Khong tim thay");
			}

			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}

	@Override
	public List<Cart> findAllCart() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Cart> query = enma.createNamedQuery("Cart.findAllCart", Cart.class);
		return query.getResultList();
	}

}
