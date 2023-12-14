package vn.iotstar.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.Cart.CartDAOImpl;
import vn.iotstar.DAO.Cart.ICartDAO;
import vn.iotstar.DAO.Cart_Product.Cart_ProductDAOImpl;
import vn.iotstar.DAO.Cart_Product.ICart_ProductDAO;
import vn.iotstar.DAO.UsersDAO.IUsersDAO;
import vn.iotstar.DAO.UsersDAO.UsersDAO_Impl;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Users;

@WebServlet(urlPatterns = { "/cart", "/cart/insert", "/cart/update", "/cart/delete" })
public class WEB_CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICartDAO cartDAO = new CartDAOImpl();
	IUsersDAO usersDAO = new UsersDAO_Impl();
	ICart_ProductDAO cpDao = new Cart_ProductDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("insert")) {

			RequestDispatcher rd = req.getRequestDispatcher("/views/web/insertCart.jsp");
			rd.forward(req, resp);

		} else if (url.contains("delete")) {
			delete(req, resp);
			Cart cart = new Cart();
			req.setAttribute("cart", cart);
		} else if (url.contains("update")) {
			String cartId = req.getParameter("CartId");
			Cart cart_present = cartDAO.findByCartId(Integer.parseInt(cartId));
			req.setAttribute("cart", cart_present);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/updateCart.jsp");
			rd.forward(req, resp);
		}
		findAll(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/listCart.jsp");
		rd.forward(req, resp);
		// req.getRequestDispatcher("/views/web/listCart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("insert")) {
			insert(req, resp);
		} else if (url.contains("update")) {
			update(req, resp);
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/web/listCart.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();

		int user_id = (int) session.getAttribute("userid");
		System.out.println("USERID: " + user_id);
		List<Cart> listCarts = cartDAO.findCartsByUserId(user_id);
		System.out.println("CartID: " + listCarts);
		// List<Cart> listCarts = cartDAO.findCartsByUserId(1);
		// List<Cart> listCarts = cartDAO.findCartsByUserId(1);

		List<Integer> number_of_cartProduct = new ArrayList<Integer>();

		for (Cart cart : listCarts) {
			if(cart.isActive()==true) {
				int sl = cpDao.countCart_ProductByCartID(cart.getCartid());
				number_of_cartProduct.add(sl);
			}
		}

		req.setAttribute("listCarts", listCarts);
		req.setAttribute("number_of_cp", number_of_cartProduct);

	}


	private void update(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String cartID = req.getParameter("cart_id");
			Cart newCart = cartDAO.findByCartId(Integer.parseInt(cartID));
			String cartCode = req.getParameter("cart_code");
			newCart.setCartcode(cartCode);
			cartDAO.update(newCart);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			int userId = (int) session.getAttribute("userid");
			Cart newCart = new Cart();
			String cart_code = req.getParameter("cart_code");

			newCart.setCartcode(cart_code);
			newCart.setActive(true);
			Users user = usersDAO.findByUserId(userId);
			newCart.setUsers(user);

			cartDAO.insert(newCart);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		String cartId = req.getParameter("CartId");
		try {
			cartDAO.delete(Integer.parseInt(cartId));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
