package vn.iotstar.DAO.Cart_Product;

import java.util.List;

import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Products;

public interface ICart_ProductDAO {	
	void insertCart_Product(Cart_Product cart_product);
	void deleteProduct (int productid) throws Exception;
	
	void deleteCart_Product (int id) throws Exception;
	
	List<Cart_Product> findCart_ProductByCartID(int cartid);
	List<Cart_Product> findAllCart_Product();	
	
	int calculateTotalPrice(int cartid);
	int countCart_ProductByCartID(int cartid);
}
