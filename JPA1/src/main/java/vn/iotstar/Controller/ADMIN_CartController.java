package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.Cart.CartDAOImpl;
import vn.iotstar.DAO.Cart.ICartDAO;
import vn.iotstar.DAO.Cart_Product.Cart_ProductDAOImpl;
import vn.iotstar.DAO.Cart_Product.ICart_ProductDAO;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Products;
import vn.iotstar.Entity.Users;
import vn.iotstar.Service.Users.IUsersService;
import vn.iotstar.Service.Users.UsersServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-cart", "/admin-findCart_ProductByCartID"})
public class ADMIN_CartController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartDAO dao = new CartDAOImpl();
	ICart_ProductDAO cpDAO = new Cart_ProductDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Cart cart = new Cart();
		if(url.contains("/admin-findCart_ProductByCartID")) {
			int cartid = cart.getCartid();
			findByCartID(req, resp, cartid);
		}
		
		findAllCart(req, resp);
		req.setAttribute("tag", "cart");
		req.getRequestDispatcher("/views/admin/Cart/list.jsp").forward(req, resp);
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
	private void findAllCart(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Cart> list = dao.findAllCart();		
			// thông báo
			req.setAttribute("carts", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		
	}

}
