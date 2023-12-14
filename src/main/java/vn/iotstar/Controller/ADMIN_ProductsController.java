package vn.iotstar.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.DAO.ProductsDAO.IProductsDAO;
import vn.iotstar.DAO.ProductsDAO.ProductsDAOImpl;
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
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-products", "/admin-products/create", "/admin-products/update",
		"/admin-products/edit", "/admin-products/delete", "/admin-products/reset" })
public class ADMIN_ProductsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	IProductsService productsService = new ProductsServiceImpl();
	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	ISuppliersService supplierService = new SupplierServiceImpl();
	ISkinsService skinService = new SkinsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Products product = null;

		if (url.contains("delete")) {
			deleteProduct(req, resp);
			product = new Products();
			req.setAttribute("product", product);

		} else if (url.contains("edit")) {
			String productid = req.getParameter("productid");
			System.out.println("product id cua ban: " + productid);
			editProduct(req, resp);

		} else if (url.contains("reset")) {
			product = new Products();
			req.setAttribute("product", product);
		}

		// gọi hàm findAll để lấy thông tin từ entity

		findAllProducts(req, resp);
		req.setAttribute("tag", "product");
		req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lấy url
		String url = req.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("create")) {
			insertProduct(req, resp);
		} else if (url.contains("update")) {
			updateProduct(req, resp);
			return;
		} else if (url.contains("delete")) {
			deleteProduct(req, resp);
		} else if (url.contains("reset")) {
			req.setAttribute("product", new Products());
		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAllProducts(req, resp);
		req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
	}

	private void findAllProducts(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			ProductsDAOImpl dao = new ProductsDAOImpl();
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<Product_Types> listt = product_typesService.findAllType();
			List<Suppliers> listsu = supplierService.findAllSupplier();
			List<Skins> listsk = skinService.findAllSkin();
			// thông báo
			req.setAttribute("types", listt);
			req.setAttribute("suppliers", listsu);
			req.setAttribute("skins", listsk);

			List<Products> list = productsService.findAllProduct();

			// thông báo
			req.setAttribute("products", list);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productid = req.getParameter("productid");

		if (productid == null) {
			req.setAttribute("error", "Please choose product to edit");
			req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
			return;
		}
		try {

			// khai báo danh sách và gọi hàm findAll() trong dao
			// List<Category> list = categoryService.findAll();

			List<Product_Types> listt = product_typesService.findAllType();
			List<Suppliers> listsu = supplierService.findAllSupplier();
			List<Skins> listsk = skinService.findAllSkin();

			// thông báo
			// request.setAttribute("categorys", list);

			req.setAttribute("types", listt);
			req.setAttribute("suppliers", listsu);
			req.setAttribute("skins", listsk);

			// khởi tạo DAO
			ProductsDAOImpl dao = new ProductsDAOImpl();
			// gọi hàm insert để thêm dữ liệu
			Products product = dao.findByProductId(Integer.parseInt(productid));
			if (product == null) {
				req.setAttribute("error", "Please choose product to edit");
				req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
				return;
			}
			// thông báo
			req.setAttribute("product", product);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
	}

	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		try {
			// lấy dữ liệu trong jsp
			String productid = req.getParameter("productid");

			productsService.deleteProduct(Integer.parseInt(productid));

			// thông báo
			req.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			Products product = new Products();
			
			// lấy dữ liệu từ jsp bằng BeanUtils
			
			BeanUtils.populate(product, req.getParameterMap());
			ProductsDAOImpl dao = new ProductsDAOImpl();
			Products oldproduct = dao.findByProductId(product.getProductid());
			// Debug: Print the product ID and whether a product was found
			System.out.println("Product ID: " + product.getProductid());
			if (oldproduct == null) {
				System.out.println("No product found with the given ID");
			} else {
				System.out.println("Found product: " + oldproduct.getProductname());
			}

			// xử lý hình
			if (oldproduct != null && req.getPart("images").getSize() == 0) {
				product.setImages(oldproduct.getImages());
			} else {

				if (oldproduct.getImages() != null) {
					// XOA ANH CU DI
					String fileName = oldproduct.getImages();
					File file = new File(Constant.DIR + "\\products\\" + fileName);
					if (file.delete()) {
						System.out.println("Đã xóa thành công");
					} else {
						System.out.println(Constant.DIR + "\\products\\" + fileName);
					}
				}
				String fileName = product.getProductname() + System.currentTimeMillis();
				product.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\products\\", fileName));
			}

			// xử lý product types, skins, suppliers
			String typeid = req.getParameter("typeid");
			Product_Types type = new Product_Types();
			type.setTypeid(Integer.parseInt(typeid));
			product.setProduct_types(type);

			String skinid = req.getParameter("skinid");
			Skins skin = new Skins();
			skin.setSkinid(Integer.parseInt(skinid));
			product.setSkins(skin);

			String supplierid = req.getParameter("supplierid");
			Suppliers supplier = new Suppliers();
			supplier.setSupplierid(Integer.parseInt(supplierid));
			product.setSuppliers(supplier);

			// gọi hàm update() trong dao
			productsService.updateProduct(product);

			// thông báo
			req.setAttribute("product", product);
			req.setAttribute("message", "Cập nhật thành công!");
			// gọi phương thức findAll
			findAllProducts(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		// response.sendRedirect(request.getContextPath() + "/admin-video");
		req.getRequestDispatcher("/views/admin/Products/list.jsp").forward(req, resp);
	}

	private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// khởi tạo đối tượng Model
			Products product = new Products();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(product, req.getParameterMap());
			// xử lý hình ảnh
			String fileName = product.getProductname() + System.currentTimeMillis();
			product.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\products\\", fileName));

			// khởi tạo DAO
			ProductsDAOImpl dao = new ProductsDAOImpl();

			// xử lý product types, skins, suppliers
			String typeid = req.getParameter("typeid");
			Product_Types type = new Product_Types();
			type.setTypeid(Integer.parseInt(typeid));
			product.setProduct_types(type);

			String skinid = req.getParameter("skinid");
			Skins skin = new Skins();
			skin.setSkinid(Integer.parseInt(skinid));
			product.setSkins(skin);

			String supplierid = req.getParameter("supplierid");
			Suppliers supplier = new Suppliers();
			supplier.setSupplierid(Integer.parseInt(supplierid));
			product.setSuppliers(supplier);

			// gọi hàm insert để thêm dữ liệu
			productsService.insertProduct(product);
			// thông báo
			req.setAttribute("message", "Đã thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

}
