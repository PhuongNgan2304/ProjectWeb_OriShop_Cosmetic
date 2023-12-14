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
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.Cart.CartDAOImpl;
import vn.iotstar.DAO.Cart.ICartDAO;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Products;
import vn.iotstar.Service.Products.IProductsService;
import vn.iotstar.Service.Products.ProductsServiceImpl;

@WebServlet(urlPatterns = { "/product/detail" })
@MultipartConfig
public class WEB_ProductDetail_Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IProductsService productsService = new ProductsServiceImpl();
	ICartDAO cartDAO = new CartDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Products products = new Products();
		String url = req.getRequestURI().toString();

		if (url.contains("/product/detail")) {
			System.out.println("DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			//int productid = 5;
			int productid = products.getProductid();
			findByProID(req, resp, productid);
			
			HttpSession session = req.getSession();
			int userID = (int)session.getAttribute("userid");
			List<Cart> listCartUser = cartDAO.findCartsByUserId(userID);
			req.setAttribute("listcartuser", listCartUser);
			System.out.println("List cart user: " + listCartUser);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-detail.jsp");
			// RequestDispatcher rd =
			// req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);
		}
	}

	private void findByProID(HttpServletRequest req, HttpServletResponse resp, int productid) {
		try {
			String productID = req.getParameter("productid");
			productid = Integer.parseInt(productID);
			Products product = productsService.findByProductId(productid);
			req.setAttribute("product", product);
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
