package vn.iotstar.DAO.Cart;

import java.util.List;

import vn.iotstar.Entity.Cart;

public interface ICartDAO {
	Cart findByCartId(int cartid);
	List<Cart> findCartsByUserId(int userId);
	List<Cart> findAllCart();
	void insert(Cart cart);
	void update(Cart cart);
	void delete(int cartId) throws Exception;
}
