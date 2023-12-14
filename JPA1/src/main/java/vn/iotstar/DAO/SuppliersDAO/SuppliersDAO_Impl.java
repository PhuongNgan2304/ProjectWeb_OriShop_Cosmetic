package vn.iotstar.DAO.SuppliersDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import vn.iotstar.Entity.Suppliers;
import vn.iotstar.JPAConfig.JPAConfig;


public class SuppliersDAO_Impl implements ISuppliersDAO{

	@Override
	public void insertSupplier(Suppliers suppliers) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(suppliers);
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
	public void updateSupplier(Suppliers suppliers) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(suppliers);
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
	public void deleteSupplier(int supplierid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Suppliers suppliers = enma.find(Suppliers.class, supplierid);
			if(suppliers != null) {
				enma.remove(suppliers);
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
	public Suppliers findBySupplierId(int supplierid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Suppliers suppliers = enma.find(Suppliers.class, supplierid);
		return suppliers;
	}

	@Override
	public List<Suppliers> findAllSupplier() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Suppliers> query= enma.createNamedQuery("Suppliers.findAllSupplier", Suppliers.class);
		return query.getResultList();
	}

	@Override
	public List<Suppliers> findBySupplierName(String suppliername) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM Suppliers u WHERE u.SupplierName like :suppname";
		TypedQuery<Suppliers> query= enma.createQuery(jpql, Suppliers.class);
		query.setParameter("SupplierName", "%" + suppliername + "%");
		
		return query.getResultList();
	}

	@Override
	public List<Suppliers> findAllSupplier(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Suppliers> query= enma.createNamedQuery("Suppliers.findAllSupplier", Suppliers.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public int countSupplier() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(u) FROM Suppliers u";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}
	
	public static void main(String[] args) {
	    SuppliersDAO_Impl suppliersDAO = new SuppliersDAO_Impl();
	    List<Suppliers> suppliersList = suppliersDAO.findAllSupplier();
	    
	    if (suppliersList != null && !suppliersList.isEmpty()) {
	        System.out.println("Có dữ liệu từ cơ sở dữ liệu.");
	        for (Suppliers suppliers : suppliersList) {
	            System.out.println("Supplier ID: " + suppliers.getSupplierid() + ", Supplier Name: " + suppliers.getSuppliername());
	        }
	    } else {
	        System.out.println("Không có dữ liệu từ cơ sở dữ liệu.");
	    }
	}
}
