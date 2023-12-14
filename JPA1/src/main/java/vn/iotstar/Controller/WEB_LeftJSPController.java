package vn.iotstar.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.SkinsDAO.ISkinsDAO;
import vn.iotstar.DAO.SkinsDAO.SkinsDAOImpl;
import vn.iotstar.Entity.Product_Types;
import vn.iotstar.Entity.Products;
import vn.iotstar.Entity.Skins;
import vn.iotstar.Entity.Suppliers;
import vn.iotstar.Service.Product_Types.IProduct_TypesService;
import vn.iotstar.Service.Product_Types.Product_TypesServiceImpl;
import vn.iotstar.Service.Products.IProductsService;
import vn.iotstar.Service.Products.ProductsServiceImpl;
import vn.iotstar.Service.Skins.ISkinsService;
import vn.iotstar.Service.Skins.SkinsServiceImpl;
import vn.iotstar.Service.Suppliers.ISuppliersService;
import vn.iotstar.Service.Suppliers.SupplierServiceImpl;

@WebServlet(urlPatterns = { "/left", "/findByTypeID_1" })
@MultipartConfig
public class WEB_LeftJSPController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProductsService productsService = new ProductsServiceImpl();
	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	ISuppliersService supplierService = new SupplierServiceImpl();
	ISkinsService skinService = new SkinsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// lấy tất cả product types
			List<Product_Types> listt = product_typesService.findAllType();
			req.setAttribute("types", listt);

			List<Suppliers> listsu = supplierService.findAllSupplier();
			req.setAttribute("suppliers", listsu);

			List<Skins> listsk = skinService.findAllSkin();
			req.setAttribute("skins", listsk);

			List<Products> listp = productsService.findAllProduct();
			req.setAttribute("products", listp);
//			System.out.println("NGANNNNNNNNNNNNNNNNNNNNNNNNNNNNNNdfgasfsdfdasdsa");
//			for (Product_Types type : listt) {
//				   System.out.println(type.getTypename().toString());
//				}

			List<Integer> listTypes = new ArrayList<>();// để test xem có lấy dc Product Types ko
			List<Integer> listCountProduct = new ArrayList<>();
			for (Product_Types product_types : listt) {

				int type = product_types.getTypeid();

				int countProduct = productsService.countProductByCategoryId(product_types.getTypeid());

				listTypes.add(type);// để test xem có lấy dc Product Types ko
				listCountProduct.add(countProduct);
			}
			Product_Types product_types = new Product_Types();

			String url = req.getRequestURI().toString();
			if (url.contains("left")) {
				RequestDispatcher rq = req.getRequestDispatcher("/commons/web/left.jsp");
				rq.forward(req, resp);

			} else if (url.contains("findByTypeID")) {
				String typeidStr = req.getParameter("typeid");
				if (typeidStr != null) {
					int typeid = Integer.parseInt(typeidStr);
					findByTypeID(req, resp, typeid);
				}
			}
			System.out.println("!!!ASDFGH!!!!");

//			List<Products> findByTypeID = productsService.findByTypeID(a);
//			req.setAttribute("products", findByTypeID);

//			for (Products product : findByTypeID) {
//				System.out.println("Product ID: " + product.getProductid());
//				System.out.println("Product Name: " + product.getProductname());
//				// In ra các thông tin khác của sản phẩm nếu cần
//			}
//			System.out.println("!!!ASDFGH!!!!");
//			System.out.println(listCountProduct);
//			System.out.println("!!!TYPES!!!!");
//			System.out.println(listTypes);
			req.setAttribute("listCountProduct", listCountProduct);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		/*
		 * RequestDispatcher rq = req.getRequestDispatcher("/commons/web/left.jsp");
		 * rq.forward(req, resp);
		 */
	}

	private void findByTypeID(HttpServletRequest req, HttpServletResponse resp, int typeid) throws ServletException, IOException {
		List<Products> findByTypeID = productsService.findByTypeID(typeid);
		req.setAttribute("types", findByTypeID);

		RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
		rd.forward(req, resp);
	}

}
