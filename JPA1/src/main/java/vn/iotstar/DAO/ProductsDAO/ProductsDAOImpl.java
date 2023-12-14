package vn.iotstar.DAO.ProductsDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Products;
import vn.iotstar.JPAConfig.JPAConfig;

public class ProductsDAOImpl implements IProductsDAO {

	@Override
	public void insertProduct(Products products) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(products);
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
	public void updateProduct(Products products) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(products);
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
	public void deleteProduct(int proid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Products products = enma.find(Products.class, proid);
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
	public Products findByProductId(int proid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Products products = enma.find(Products.class, proid);
		return products;
	}

	@Override
	public List<Products> findAllProduct() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Products> query = enma.createNamedQuery("Products.findAllProduct", Products.class);
		return query.getResultList();
	}

	@Override
	public List<Products> getTop3() {
		EntityManager enma = JPAConfig.getEntityManager();
		Query query = enma.createQuery("SELECT p FROM Products p");
		query.setMaxResults(3);
		return query.getResultList();
	}

	@Override
	public List<Products> findByTypeID(int typeid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Products p WHERE p.product_types.typeid = :typeid";
		TypedQuery<Products> query = enma.createQuery(jpql, Products.class);
		query.setParameter("typeid", typeid);
		return query.getResultList();
	}

	@Override
	public List<Products> findBySkinID(int skinid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Products p WHERE p.skins.skinid = :skinid";
		TypedQuery<Products> query = enma.createQuery(jpql, Products.class);
		query.setParameter("skinid", skinid);
		return query.getResultList();
	}

	@Override
	public List<Products> findBySupplierID(int supplierid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Products p	 WHERE p.suppliers.supplierid = :supplierid";
		TypedQuery<Products> query = enma.createQuery(jpql, Products.class);
		query.setParameter("supplierid", supplierid);
		return query.getResultList();
	}

	@Override
	public List<Products> findByProductName(String proname) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT p FROM Category p WHERE p.ProductName like :proname";
		TypedQuery<Products> query = enma.createQuery(jpql, Products.class);
		query.setParameter("ProductName", "%" + proname + "%");

		return query.getResultList();
	}

	@Override
	public List<Products> findAllProduct(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Products> query = enma.createNamedQuery("Products.findAllProduct", Products.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public int countProductByCategoryId(int typeid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(p) FROM Products p WHERE p.product_types.typeid = :typeid";
		Query query = enma.createQuery(jpql);
		query.setParameter("typeid", typeid);
		long result = (long) query.getSingleResult(); // Cast the result to long
		return (int) result; // Cast the long result to int
	}

	@Override
	public int countProductBySkinId(int skinid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(p) FROM Products p WHERE p.skins.skinid = :skinid";
		Query query = enma.createQuery(jpql);
		query.setParameter("skinid", skinid);
		long result = (long) query.getSingleResult(); // Cast the result to long
		return (int) result;
	}

	@Override
	public int countProductBySupplierId(int supplierid) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(p) FROM Products p WHERE p.suppliers.supplierid = :supplierid";
		Query query = enma.createQuery(jpql);
		query.setParameter("supplierid", supplierid);
		long result = (long) query.getSingleResult(); // Cast the result to long
		return (int) result;
	}

//	@Override
//	public List<Object[]> countProductByType() {
//		EntityManager enma = JPAConfig.getEntityManager();
//		String jpql = "SELECT p.product_types.typeid, COUNT(p) FROM Products p GROUP BY p.product_types.typeid";
//		Query query = enma.createQuery(jpql);
//		return query.getResultList();
//	}

	public static void main(String[] args) {
		ProductsDAOImpl productsDAO = new ProductsDAOImpl();
		List<Products> getTop3 = productsDAO.getTop3();
		
		for (Products products: getTop3) {
			System.out.println("Tên sản phẩm: " + products.getProductname());
		}

//		ProductsDAOImpl productsDAO = new ProductsDAOImpl();
//		Products pro = productsDAO.findByProductId(5);
//
//		if (pro != null) {
//			System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
//			System.out.println("Pro ID: 5 " + ", Product Name: " + pro.getProductname());
//		} else {
//			System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
//		}

//		ProductsDAOImpl productsDAO = new ProductsDAOImpl();
//		List<Products> productsList = productsDAO.findBySkinID(6);
//
//		if (productsList != null && !productsList.isEmpty()) {
//			System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
//			for (Products products : productsList) {
//				System.out.println("Skin ID: 6 " + ", Product Name: " + products.getProductname());
//			}
//		} else {
//			System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
//		}

//		ProductsDAOImpl dao = new ProductsDAOImpl();
//		List<Object[]> results = dao.countProductByType();
//		for (Object[] result : results) {
//			int typeid = (Integer) result[0];
//			long numProduct = (Long) result[1];
//			System.out.println("TypeID: " + typeid + ", Number of products: " + numProduct);
//		}

//		ProductsDAOImpl productDAO = new ProductsDAOImpl();
//		int count = productDAO.countProductByCategoryId(27); // Replace 1 with the actual typeid you want to test
//
//		System.out.println("Number of products with typeid 27: " + count);

	}

}
