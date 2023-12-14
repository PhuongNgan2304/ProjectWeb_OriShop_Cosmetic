package vn.iotstar.DAO.ProductsDAO;

import java.util.List;

import vn.iotstar.Entity.Products;

public interface IProductsDAO {
	void insertProduct(Products products);
	void updateProduct(Products products);
	void deleteProduct(int proid) throws Exception;
	
	Products findByProductId(int proid);
	List<Products> findByTypeID(int typeid);
	List<Products> findBySkinID(int skinid);
	List<Products> findBySupplierID(int supplierid);
	
//	List<Products> findByCartID (int cartid);
	
	List<Products> findAllProduct();
	List<Products> findByProductName(String proname);
	List<Products> findAllProduct(int page,int pagesize);
	
	List<Products> getTop3();
	
	int countProductByCategoryId (int typeid);
	int countProductBySkinId (int skinid);
	int countProductBySupplierId (int supplierid);
	
	
	//List<Object[]> countProductByType();
}
