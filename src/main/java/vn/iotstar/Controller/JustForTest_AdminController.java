package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.Entity.Product_Types;
import vn.iotstar.Service.Product_Types.IProduct_TypesService;
import vn.iotstar.Service.Product_Types.Product_TypesServiceImpl;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-types"})
public class JustForTest_AdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAllTypes(req, resp);
		req.setAttribute("tag", "type");
		req.getRequestDispatcher("/decorators/admin.jsp").forward(req, resp);
	}
	private void findAllTypes(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Product_Types> product_types = product_typesService.findAllType();
			req.setAttribute("product_types", product_types);
			Product_Types product_type = new Product_Types();
			req.setAttribute("product_type", product_type);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
