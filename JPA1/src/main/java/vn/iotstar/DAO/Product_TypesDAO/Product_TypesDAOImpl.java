package vn.iotstar.DAO.Product_TypesDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.iotstar.Entity.Product_Types;
import vn.iotstar.JPAConfig.JPAConfig;


public class Product_TypesDAOImpl implements IProduct_TypesDAO{

	@Override
	public void insertType(Product_Types product_type) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(product_type);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}

	@Override
	public void updateType(Product_Types product_type) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(product_type);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
		
	}

	@Override
	public void deleteType(int typeid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Product_Types product_types = enma.find(Product_Types.class,typeid);
			if(product_types != null) {
				enma.remove(product_types);
			}else {
				throw new Exception("Không tìm thấy");
			}

			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}

	@Override
	public Product_Types findByTypeId(int typeid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Product_Types product_type = enma.find(Product_Types.class,typeid);
		return product_type;
	}

	@Override
	public List<Product_Types> findAllType() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Product_Types> query= enma.createNamedQuery("Product_Types.findAllType", Product_Types.class);
		return query.getResultList();
	}

	@Override
	public List<Product_Types> findByTypeName(String typename) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT t FROM Product_Types t WHERE t.TypeName like :typename";
		TypedQuery<Product_Types> query= enma.createQuery(jpql, Product_Types.class);
		query.setParameter("catename", "%" + typename + "%");
		
		return query.getResultList();
	}

	@Override
	public List<Product_Types> findAllType(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Product_Types> query= enma.createNamedQuery("Product_Types.findAllType", Product_Types.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public int countType() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(t) FROM Product_Types t";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
	
	public static void main(String[] args) {
	    Product_TypesDAOImpl product_typesDAO = new Product_TypesDAOImpl();
	    List<Product_Types> product_typesList = product_typesDAO.findAllType();
	    
	    if (product_typesList != null && !product_typesList.isEmpty()) {
	        System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
	        for (Product_Types product_types : product_typesList) {
	            System.out.println("Type ID: " + product_types.getTypeid() + ", Type Name: " + product_types.getTypename());
	        }
	    } else {
	        System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
	    }
	}

}
