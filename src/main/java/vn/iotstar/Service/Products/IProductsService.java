package vn.iotstar.Service.Products;

import java.util.List;

import vn.iotstar.Entity.Products;

public interface IProductsService {
	void insertProduct(Products products);
	void updateProduct(Products products);
	void deleteProduct(int proid) throws Exception;
	Products findByProductId(int proid);
	
	List<Products> findByTypeID(int typeid);
	List<Products> findBySkinID(int skinid);
	List<Products> findBySupplierID(int supplierid);
	
	List<Products> getTop3();
	
	List<Products> findAllProduct();
	List<Products> findByProductName(String proname);
	List<Products> findAllProduct(int page,int pagesize);
	
	int countProductByCategoryId (int typeid);
	int countProductBySkinId (int skinid);
	int countProductBySupplierId (int supplierid);
	
//	List<Object[]> countProductByType();
}
