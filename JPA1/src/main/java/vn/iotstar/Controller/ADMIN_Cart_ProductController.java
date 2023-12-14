package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;

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


@MultipartConfig

@WebServlet(urlPatterns = { "/admin-cart_product" })
public class ADMIN_Cart_ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICart_ProductDAO dao = new Cart_ProductDAOImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAllCart_Product(req, resp);
		req.setAttribute("tag", "cart_product");
		req.getRequestDispatcher("/views/admin/Cart_Product/list.jsp").forward(req, resp);
	}

	private void findAllCart_Product(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Cart_Product> list = dao.findAllCart_Product();
			
			
			// thông báo
			req.setAttribute("cart_products", list);
			
			//req.setAttribute("users", listu);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		
	}
}
