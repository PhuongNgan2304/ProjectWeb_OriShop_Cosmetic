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

import vn.iotstar.DAO.Cart.CartDAOImpl;
import vn.iotstar.DAO.Cart.ICartDAO;
import vn.iotstar.Entity.Cart;
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

@WebServlet(urlPatterns = { "/findAll", "/findByTypeID", "/findBySkinID", "/findBySupplierID" })
@MultipartConfig
public class WEB_Product_GridController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IProductsService productsService = new ProductsServiceImpl();
	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	ISuppliersService supplierService = new SupplierServiceImpl();
	ISkinsService skinService = new SkinsServiceImpl();

	ICartDAO cartDAO = new CartDAOImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// lấy tất cả product types
			List<Product_Types> listt = product_typesService.findAllType();
			req.setAttribute("types", listt);

			List<Products> list = productsService.findAllProduct();
			req.setAttribute("products", list);

			List<Suppliers> listsu = supplierService.findAllSupplier();
			req.setAttribute("suppliers", listsu);

			List<Skins> listsk = skinService.findAllSkin();
			req.setAttribute("skins", listsk);

			List<Integer> listTypes = new ArrayList<>();// để test xem có lấy dc Product Types ko
			List<Integer> listCountProduct = new ArrayList<>();
			for (Product_Types product_types : listt) {

				int type = product_types.getTypeid();

				int countProduct = productsService.countProductByCategoryId(product_types.getTypeid());

				listTypes.add(type);// để test xem có lấy dc Product Types ko
				listCountProduct.add(countProduct);
			}
			req.setAttribute("listCountProduct", listCountProduct);

			List<Integer> listSkins = new ArrayList<>();// để test xem có lấy dc Product Types ko
			List<Integer> listCountProductBySkins = new ArrayList<>();
			for (Skins skins : listsk) {

				int skin = skins.getSkinid();
				int countProductBySkin = productsService.countProductBySkinId(skins.getSkinid());

				listSkins.add(skin);
				listCountProductBySkins.add(countProductBySkin);
			}
			req.setAttribute("listCountProductBySkins", listCountProductBySkins);

			List<Integer> listSuppliers = new ArrayList<>();// để test xem có lấy dc Product Types ko
			List<Integer> listCountProductBySuppliers = new ArrayList<>();
			for (Suppliers suppliers : listsu) {

				int supplier = suppliers.getSupplierid();
				int countProductBySupplier = productsService.countProductBySupplierId(suppliers.getSupplierid());

				listSuppliers.add(supplier);
				listCountProductBySuppliers.add(countProductBySupplier);
			}
			req.setAttribute("listCountProductBySuppliers", listCountProductBySuppliers);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}

		Product_Types product_types = new Product_Types();
		Skins skins = new Skins();
		Suppliers suppliers = new Suppliers();

		//Products products = new Products();

		String url = req.getRequestURL().toString();

		if (url.contains("findByTypeID")) {
			int typeid = product_types.getTypeid();
			findByTypeID(req, resp, typeid);

		} else if (url.contains("findAll")) {
			findAll(req, resp);
			
		} else if (url.contains("findBySkinID")) {
			int skinid = skins.getSkinid();
			findBySkinID(req, resp, skinid);
			
		} else if (url.contains("findBySupplierID")) {
			int supplierid = suppliers.getSupplierid();
			findBySupplierID(req, resp, supplierid);
		}
		RequestDispatcher rq = req.getRequestDispatcher("/views/web/product-grid.jsp");
		rq.forward(req, resp);

		// TEST THỬ
		System.out.println("!!!ASDFGH!!!!");
		Products pro = productsService.findByProductId(5);
		req.setAttribute("products", pro);
		System.out.println("Product ID: " + pro.getProductid());
		System.out.println("Product Name: " + pro.getProductname());
		System.out.println("Product Skin: " + pro.getSkins().getSkinname());
		// In ra các thông tin khác của sản phẩm nếu cần

//		List<Products> findByTypeID = productsService.findByTypeID(8);
		List<Products> findBySkinID = productsService.findBySkinID(6);
		req.setAttribute("products", findBySkinID);

		for (Products product : findBySkinID) {
			System.out.println("Skin ID: 6" );
			System.out.println("Product ID: " + product.getProductid());
			System.out.println("Product Name: " + product.getProductname());
			// In ra các thông tin khác của sản phẩm nếu cần
		}
////		RequestDispatcher rq = req.getRequestDispatcher("/views/web/product-grid.jsp");
////		rq.forward(req, resp);
	}

	private void findBySupplierID(HttpServletRequest req, HttpServletResponse resp, int supplierid) throws ServletException, IOException {
		try {
			String suppID = req.getParameter("supplierid");
			supplierid = Integer.parseInt(suppID);
			List<Products> listt = productsService.findBySupplierID(supplierid);
			req.setAttribute("products", listt);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

	private void findBySkinID(HttpServletRequest req, HttpServletResponse resp, int skinid) throws ServletException, IOException {
		try {
			String skID = req.getParameter("skinid");
			skinid = Integer.parseInt(skID);
			List<Products> listt = productsService.findBySkinID(skinid);
			req.setAttribute("products", listt);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

//	private void findByProID(HttpServletRequest req, HttpServletResponse resp, int productid) throws ServletException, IOException{
//		try {
//			String productID = req.getParameter("productid");
//			productid = Integer.parseInt(productID);
//			Products product = productsService.findByProductId(productid);
//			req.setAttribute("product", product);
//			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-detail.jsp");
//			//RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
//			rd.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("error", "Fails");
//		}
//	}

	private void findByTypeID(HttpServletRequest req, HttpServletResponse resp, int typeid)
			throws ServletException, IOException {

		try {
			String cateID = req.getParameter("typeid");
			typeid = Integer.parseInt(cateID);
			List<Products> listt = productsService.findByTypeID(typeid);
			req.setAttribute("products", listt);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Products> listt = productsService.findAllProduct();
			req.setAttribute("products", listt);
			RequestDispatcher rd = req.getRequestDispatcher("/views/web/product-grid.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Fails");
		}
	}

}
