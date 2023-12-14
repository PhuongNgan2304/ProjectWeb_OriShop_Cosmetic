package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.Cart_Product.Cart_ProductDAOImpl;
import vn.iotstar.DAO.Cart_Product.ICart_ProductDAO;
import vn.iotstar.DAO.Order_User.IOrder_UserDAO;
import vn.iotstar.DAO.Order_User.Order_UserDAOImpl;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Order_User;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-order_user", "/admin-order_user-findCart_ProductByCartID"})
public class ADMIN_Order_UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IOrder_UserDAO dao = new Order_UserDAOImpl();
	ICart_ProductDAO cpDAO = new Cart_ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Cart cart = new Cart();
		if(url.contains("/admin-order_user-findCart_ProductByCartID")) {
			int cartid = cart.getCartid();
			findByCartID(req, resp, cartid);
		}
		
		findAllOrder_User(req, resp);
		req.setAttribute("tag", "order_user");
		req.getRequestDispatcher("/views/admin/Order_User/list.jsp").forward(req, resp);
	}
	private void findByCartID(HttpServletRequest req, HttpServletResponse resp, int cartid) {
		try {
			String cartID = req.getParameter("cartid");
			cartid = Integer.parseInt(cartID);
			List<Cart_Product>listcp = cpDAO.findCart_ProductByCartID(cartid);
			req.setAttribute("cart_products", listcp);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/Cart_Product/list.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
		
	}
	private void findAllOrder_User(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Order_User> list = dao.findAllOrderUser();		
			// thông báo
			req.setAttribute("order_users", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		
	}

}
