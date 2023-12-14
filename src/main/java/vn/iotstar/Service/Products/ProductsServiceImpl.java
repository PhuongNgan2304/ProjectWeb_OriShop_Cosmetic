package vn.iotstar.Service.Products;

import java.util.List;

import vn.iotstar.DAO.ProductsDAO.IProductsDAO;
import vn.iotstar.DAO.ProductsDAO.ProductsDAOImpl;
import vn.iotstar.Entity.Products;

public class ProductsServiceImpl implements IProductsService{
	IProductsDAO productsDao =new ProductsDAOImpl();
	@Override
	public void insertProduct(Products products) {
		productsDao.insertProduct(products);
	}

	@Override
	public void updateProduct(Products products) {
		productsDao.updateProduct(products);
	}

	@Override
	public void deleteProduct(int proid) throws Exception {
		productsDao.deleteProduct(proid);
	}

	@Override
	public Products findByProductId(int proid) {
		return productsDao.findByProductId(proid);
	}

	@Override
	public List<Products> findAllProduct() {
		return productsDao.findAllProduct();
	}

	@Override
	public List<Products> findByProductName(String proname) {
		return productsDao.findByProductName(proname);
	}

	@Override
	public List<Products> findAllProduct(int page, int pagesize) {
		return productsDao.findAllProduct(page, pagesize);
	}

	

//	@Override
//	public List<Object[]> countProductByType() {
//		return productsDao.countProductByType();
//	}

	@Override
	public int countProductByCategoryId(int typeid) {
		return productsDao.countProductByCategoryId(typeid);
	}

	@Override
	public List<Products> findByTypeID(int typeid) {
		return productsDao.findByTypeID(typeid);
	}

	@Override
	public List<Products> findBySkinID(int skinid) {
		return productsDao.findBySkinID(skinid);
	}

	@Override
	public List<Products> findBySupplierID(int supplierid) {
		return productsDao.findBySupplierID(supplierid);
	}

	@Override
	public int countProductBySkinId(int skinid) {
		return productsDao.countProductBySkinId(skinid);
	}

	@Override
	public int countProductBySupplierId(int supplierid) {
		return productsDao.countProductBySupplierId(supplierid);
	}

	@Override
	public List<Products> getTop3() {
		return productsDao.getTop3();
	}
	

}
