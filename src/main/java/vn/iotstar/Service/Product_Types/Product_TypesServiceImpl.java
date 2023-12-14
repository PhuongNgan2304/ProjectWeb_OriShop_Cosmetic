package vn.iotstar.Service.Product_Types;

import java.util.List;

import vn.iotstar.DAO.Product_TypesDAO.IProduct_TypesDAO;
import vn.iotstar.DAO.Product_TypesDAO.Product_TypesDAOImpl;
import vn.iotstar.Entity.Product_Types;

public class Product_TypesServiceImpl implements IProduct_TypesService {
	IProduct_TypesDAO product_typesDao =new Product_TypesDAOImpl();
	@Override
	public void insertType(Product_Types product_type) {
		product_typesDao.insertType(product_type);
	}

	@Override
	public void updateType(Product_Types product_type) {
		product_typesDao.updateType(product_type);
	}

	@Override
	public void deleteType(int typeid) throws Exception {
		product_typesDao.deleteType(typeid);
	}

	@Override
	public Product_Types findByTypeId(int typeid) {
		return product_typesDao.findByTypeId(typeid);
	}

	@Override
	public List<Product_Types> findAllType() {
		return product_typesDao.findAllType();
	}

	@Override
	public List<Product_Types> findByTypeName(String typename) {
		return product_typesDao.findByTypeName(typename);
	}

	@Override
	public List<Product_Types> findAllType(int page, int pagesize) {
		return product_typesDao.findAllType(page, pagesize);
	}

	@Override
	public int countType() {
		return product_typesDao.countType();
	}

}
