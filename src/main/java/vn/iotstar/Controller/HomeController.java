package vn.iotstar.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.ProductsDAO.ProductsDAOImpl;
import vn.iotstar.Entity.Product_Types;
import vn.iotstar.Entity.Products;
import vn.iotstar.Service.Product_Types.IProduct_TypesService;
import vn.iotstar.Service.Product_Types.Product_TypesServiceImpl;
import vn.iotstar.Service.Products.IProductsService;
import vn.iotstar.Service.Products.ProductsServiceImpl;

@WebServlet(urlPatterns = { "/home",  "/findProductByTypeID" })
@MultipartConfig
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IProductsService productsService = new ProductsServiceImpl();
	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// lấy tất cả sản phẩm
			ProductsDAOImpl dao = new ProductsDAOImpl();
			List<Products> list = dao.findAllProduct();
			req.setAttribute("products", list);
			// lấy tất cả product types
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<Product_Types> listt = product_typesService.findAllType();
			// thông báo
			req.setAttribute("types", listt);
			
			List<Integer> listTypes = new ArrayList<>();//để test xem có lấy dc Product Types ko
			List<Integer> listCountProduct = new ArrayList<>();
			for (Product_Types product_types: listt) {
				
				int type = product_types.getTypeid();
				
				int countProduct = productsService.countProductByCategoryId(product_types.getTypeid());
				
				listTypes.add(type);//để test xem có lấy dc Product Types ko
				listCountProduct.add(countProduct);
			}
			System.out.println("!!!ASDFGH!!!!");
			System.out.println(listCountProduct);
			System.out.println("!!!TYPES!!!!");
			System.out.println(listTypes);
			req.setAttribute("listCountProduct", listCountProduct);


//			// đếm số lượng sản phẩm theo từng typeid
//			List<Object[]> counts = dao.countProductByType();
//			req.setAttribute("counts", counts);
//
//			// tạo một HashMap để lưu trữ số lượng sản phẩm theo typeid
//			Map<Integer, Integer> countsMap = new HashMap<>();
//			for (Object[] count : counts) {
//				countsMap.put((Integer) count[0], (Integer) count[1]);
//			}
//			req.setAttribute("countsMap", countsMap);
//			System.out.printf("!!!!SDFGHGFDSA!!!!",countsMap);


		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		String url = req.getRequestURL().toString();
		Product_Types product_types = new Product_Types();
		
		if(url.contains("/findProductByTypeID")) {
			int typeid = product_types.getTypeid();
			findByTypeID(req, resp, typeid);
		} else if(url.contains("/home")) {
			findAll(req, resp);
			RequestDispatcher rq = req.getRequestDispatcher("/views/web/home.jsp");
			rq.forward(req, resp);
		}
	}

	private void findByTypeID(HttpServletRequest req, HttpServletResponse resp, int typeid) {
		try {
			String typeID = req.getParameter("typeid");
			typeid = Integer.parseInt(typeID);
			List<Products>listt = productsService.findByTypeID(typeid);
			req.setAttribute("products", listt);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// khởi tạo DAO
			ProductsDAOImpl dao = new ProductsDAOImpl();
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<Products> list = dao.findAllProduct();

			// thông báo
			req.setAttribute("listP", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
