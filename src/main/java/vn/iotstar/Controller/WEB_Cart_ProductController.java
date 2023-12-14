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
import vn.iotstar.DAO.ProductsDAO.IProductsDAO;
import vn.iotstar.DAO.ProductsDAO.ProductsDAOImpl;
import vn.iotstar.Entity.Cart;
import vn.iotstar.Entity.Cart_Product;
import vn.iotstar.Entity.Products;

@WebServlet(urlPatterns = { "/findAllCart_Product", "/Cart_Product/insert", "/Cart_Product/delete" })
@MultipartConfig
public class WEB_Cart_ProductController extends HttpServlet {

	ICart_ProductDAO cpDAO = new Cart_ProductDAOImpl();
	ICartDAO cartDAO = new CartDAOImpl();
	//ICartDAO cDAO = new CartDAOImpl();
	IProductsDAO productDAO = new ProductsDAOImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * try { User user = new User();
		 * 
		 * user.setEmail("trungnh@fit.hcmute.edu.vn");
		 * user.setFullname("Nguyễn Hữu Trung"); user.setPassword("123");
		 * user.setAdmin(true); UserDao dao = new UserDao(); dao.insert(user);
		 * System.out.println("Done"); } catch (Exception e) { // TODO: handle exception
		 * }
		 */
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url

//		try {
////			Cart_Product cp = new Cart_Product();
////			Cart c = new Cart();
////			Products p = new Products();
////			p.setProductid(11);
////			c.setCartid(1);
////			
////			cp.setCart(c);
////			cp.setProduct(p);
////			cp.setQuantity(12);
////			cp.setTotalPrice(190000);		
////			cpDAO.insertProduct(p);
//			Cart_Product cp = new Cart_Product();
//			Products p = productDAO.findByProductId(11);
//			
//			System.out.println(p);
//			
//			Cart c = cDAO.findByCartId(1);
//			cp.setProduct(p);
//			cp.setCart(c);
//			cpDAO.insertCart_Product(cp);
//			
//			System.out.println("Done");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String url = req.getRequestURL().toString();
		if (url.contains("/Cart_Product/delete")){
			deleteCart_Product(req, resp);
			System.out.println(cpDAO.findCart_ProductByCartID(12));

		}
		String cartid = req.getParameter("CartId");
		int totalPrice = cpDAO.calculateTotalPrice(Integer.parseInt(cartid));
		req.setAttribute("totalPrice", totalPrice);
		findAll(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/list-cart.jsp");
		rd.forward(req, resp);
	}


	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		String cartid =req.getParameter("CartId");
		List<Cart_Product> listCart_Products = cpDAO.findCart_ProductByCartID(Integer.parseInt(cartid));
		req.setAttribute("cart", listCart_Products);
		req.setAttribute("cartid", cartid);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = req.getRequestURL().toString();
		if (url.contains("/Cart_Product/insert")) {
			insertCart_Product(req, resp);
			req.setAttribute("thongbao", "Thêm sản phẩm vào giỏ hàng thành công");
			
			String cartid = req.getParameter("giohang");
			List<Cart_Product> cart_product = cpDAO.findCart_ProductByCartID(Integer.parseInt(cartid));
			req.setAttribute("cart", cart_product);
			
			int totalPrice = cpDAO.calculateTotalPrice(Integer.parseInt(cartid));
			req.setAttribute("totalPrice", totalPrice);
			
			req.setAttribute("cartid", cartid);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/list-cart.jsp");
			rd.forward(req, resp);
		
		} else if (url.contains("/Cart_Product/delete")) {
			deleteCart_Product(req, resp);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/list-cart.jsp");
			rd.forward(req, resp);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/list-cart.jsp");
		rd.forward(req, resp);
		
//		String cartId =req.getParameter("CartId");
//		List<Cart_Product> listCart_Products=cpDAO.findCart_ProductByCartID(Integer.parseInt(cartId));
//		req.setAttribute("listCart_Products", listCart_Products);
//		RequestDispatcher rd= req.getRequestDispatcher("/views/web/listCartProduct.jsp");
//		rd.forward(req, resp);
		
		
	}
	private void deleteCart_Product(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// lấy dữ liệu trong jsp
			String id = req.getParameter("id");
			//List<Cart_Product> cart_product = cpDAO.findAllCart_Product();
			cpDAO.deleteCart_Product(Integer.parseInt(id));

			// thông báo
			//req.setAttribute("cart_product", cart_product);
			req.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		
	}


	private void findProductByProductID(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
		Products product = new Products();
		product = productDAO.findByProductId(id);
		req.setAttribute("product", product);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-detail.jsp");
		rd.forward(req, resp);
	}

	private void insertCart_Product(HttpServletRequest req, HttpServletResponse resp) {
		String cartid = req.getParameter("giohang");
		String soluong = req.getParameter("quantity");
		String productid = req.getParameter("productid");
		
		Products product = productDAO.findByProductId(Integer.parseInt(productid));
		Cart cart = cartDAO.findByCartId(Integer.parseInt(cartid));
		
		int SL = Integer.parseInt(soluong);
		int price = product.getPrice();
		int tongtien = SL*price;
		
		Cart_Product cartproduct = new Cart_Product();
		cartproduct.setProduct(product);
		cartproduct.setQuantity(SL);
		cartproduct.setTotalPrice(tongtien);
		cartproduct.setCart(cart);
		
		cpDAO.insertCart_Product(cartproduct);
		
		System.out.println("Cart: " + cart);
		System.out.println("Soluong: " + soluong);
		System.out.println("ProID: " + productid);
	}

}
