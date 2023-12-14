package vn.iotstar.Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.Cart.CartDAOImpl;
import vn.iotstar.DAO.Cart.ICartDAO;
import vn.iotstar.DAO.Cart_Product.Cart_ProductDAOImpl;
import vn.iotstar.DAO.Cart_Product.ICart_ProductDAO;
import vn.iotstar.DAO.Order_User.IOrder_UserDAO;
import vn.iotstar.DAO.Order_User.Order_UserDAOImpl;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Order_User;

@WebServlet(urlPatterns = {"/order", "/order/insert"})
public class WEB_Order_UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartDAO cartdao = new CartDAOImpl();
	IOrder_UserDAO order_UserDAO = new Order_UserDAOImpl();
	ICart_ProductDAO cpDAO =new Cart_ProductDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		
		String cartid = req.getParameter("cartid");
		Cart cart = cartdao.findByCartId(Integer.parseInt(cartid));
		
		
		int totalPrice = cpDAO.calculateTotalPrice(Integer.parseInt(cartid));
		req.setAttribute("totalPrice", totalPrice);
		req.setAttribute("cart", cart);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/orderbuy-list.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		
		if(url.contains("insert")) {
			insert(req, resp);
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartid = req.getParameter("cartid");
		
		String address=req.getParameter("address");
		Cart cart =cartdao.findByCartId(Integer.parseInt(cartid));
		Order_User order =new Order_User();
		order.setAddress(address);
		order.setCart(cart);
		order.setPaid(true);
		order.setOrderdate(new Date());
		order.setTotal(cpDAO.calculateTotalPrice(Integer.parseInt(cartid)));
		
		cart.setActive(false);
		cart.setCartid(Integer.parseInt(cartid));
		cartdao.update(cart);
		
		order_UserDAO.insertOrder_User(order);
		RequestDispatcher rd =req.getRequestDispatcher("/views/web/pay_success.jsp");
		rd.forward(req, resp);
	}

}
