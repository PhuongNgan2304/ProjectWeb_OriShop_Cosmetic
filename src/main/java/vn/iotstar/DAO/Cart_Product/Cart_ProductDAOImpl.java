package vn.iotstar.DAO.Cart_Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Products;
import vn.iotstar.JPAConfig.JPAConfig;

public class Cart_ProductDAOImpl implements ICart_ProductDAO {

	@Override
	public void insertCart_Product(Cart_Product cart_product) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(cart_product);
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
	public void deleteProduct(int productid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Products products = enma.find(Products.class, productid);
			if (products != null) {
				enma.remove(products);
			} else {
				throw new Exception("Không tìm thấy");
			}

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
	public List<Cart_Product> findCart_ProductByCartID(int cartid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM Cart_Product c WHERE c.cart.cartid = :cartid";
		TypedQuery<Cart_Product> query = enma.createQuery(jpql, Cart_Product.class);
		query.setParameter("cartid", cartid);
		return query.getResultList();
	}

	public static void main(String[] args) {
		Cart_ProductDAOImpl dao = new Cart_ProductDAOImpl();
		int total = dao.calculateTotalPrice(3);
		System.out.println("Tổng tiền: " + total);
//	    Cart_ProductDAOImpl cart_productDAO = new Cart_ProductDAOImpl();
//	    List<Cart_Product> cart_productList = cart_productDAO.findCart_ProductByCartID(1);
//	    
//	    if (cart_productList != null && !cart_productList.isEmpty()) {
//	        System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
//	        for (Cart_Product cart_products : cart_productList) {
//	            System.out.println("CartID: 1 " + ", Cart_Product_ID: " + cart_products.getId());
//	        }
//	    } else {
//	        System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
//	    }

	}

	@Override
	public int calculateTotalPrice(int cartid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT SUM(cp.totalPrice) FROM Cart_Product cp WHERE cp.cart.cartid = :cartid";
		Query query = enma.createQuery(jpql);
		query.setParameter("cartid", cartid);
		long result = (long) query.getSingleResult(); // Cast the result to long
		return (int) result;
	}

	@Override
	public int countCart_ProductByCartID(int cartid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(*) FROM Cart_Product cp WHERE cp.cart.cartid = :cartid";
		Query query = enma.createQuery(jpql);
		query.setParameter("cartid", cartid);
		long result = (long) query.getSingleResult(); // Cast the result to long
		return (int) result;
	}

	@Override
	public void deleteCart_Product(int id) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Cart_Product cart_product = enma.find(Cart_Product.class, id);
			if (cart_product != null) {
				enma.remove(cart_product);
			} else {
				throw new Exception("Không tìm thấy");
			}
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
	public List<Cart_Product> findAllCart_Product() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Cart_Product> query = enma.createNamedQuery("Cart_Product.findAllCart_Product", Cart_Product.class);
		return query.getResultList();
	}

}
