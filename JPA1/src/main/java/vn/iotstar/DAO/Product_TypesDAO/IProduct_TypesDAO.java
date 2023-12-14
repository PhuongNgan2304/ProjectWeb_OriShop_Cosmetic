package vn.iotstar.DAO.Product_TypesDAO;

import java.util.List;

import vn.iotstar.Entity.Product_Types;


public interface IProduct_TypesDAO {
	void insertType(Product_Types product_type);
	void updateType(Product_Types product_type);
	void deleteType(int typeid) throws Exception;
	Product_Types findByTypeId(int typeid);
	List<Product_Types> findAllType();
	List<Product_Types> findByTypeName(String typename);
	List<Product_Types> findAllType(int page,int pagesize);
	int countType();
}
