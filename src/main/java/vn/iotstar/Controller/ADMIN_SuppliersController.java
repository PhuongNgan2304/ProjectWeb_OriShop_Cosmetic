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

import vn.iotstar.Entity.Product_Types;
import vn.iotstar.Entity.Suppliers;
import vn.iotstar.Service.Suppliers.ISuppliersService;
import vn.iotstar.Service.Suppliers.SupplierServiceImpl;
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin-suppliers", "/admin-suppliers/create", "/admin-suppliers/update",
		"/admin-suppliers/edit", "/admin-suppliers/delete", "/admin-suppliers/reset" })
public class ADMIN_SuppliersController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	ISuppliersService suppliersService = new SupplierServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Suppliers supplier = null;

		if (url.contains("delete")) {
			deleteSupplier(req, resp);
			supplier = new Suppliers();
			req.setAttribute("supplier", supplier);

		} else if (url.contains("edit")) {
			editSupplier(req, resp);

		} else if (url.contains("reset")) {
			supplier = new Suppliers();
			req.setAttribute("supplier", supplier);
		}

		// gọi hàm findAll để lấy thông tin từ entity

		findAllSuppliers(req, resp);
		req.setAttribute("tag", "supplier");
		req.getRequestDispatcher("/views/admin/Suppliers/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lấy url
		String url = req.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("create")) {
			insertSupplier(req, resp);
		} else if (url.contains("update")) {
			updateSupplier(req, resp);
		} else if (url.contains("delete")) {
			deleteSupplier(req, resp);
		} else if (url.contains("reset")) {
			req.setAttribute("supplier", new Suppliers());
		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAllSuppliers(req, resp);
		req.getRequestDispatcher("/views/admin/Suppliers/list.jsp").forward(req, resp);
	}

	private void findAllSuppliers(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Suppliers> list = suppliersService.findAllSupplier();

			// thông báo
			req.setAttribute("suppliers", list);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void insertSupplier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			Suppliers supplier = new Suppliers();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(supplier, req.getParameterMap());
			// xử lý hình ảnh
			String fileName = supplier.getCountry() + System.currentTimeMillis();
			supplier.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\suppliers\\", fileName));

			// gọi hàm insert để thêm dữ liệu
			// category.setStatus(true);
			suppliersService.insertSupplier(supplier);
			// thông báo
			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void editSupplier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			String supplierid = req.getParameter("supplierid");

			Suppliers supplier = suppliersService.findBySupplierId(Integer.parseInt(supplierid));
			// thông báo
			req.setAttribute("supplier", supplier);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
	private void updateSupplier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			Suppliers supplier = new Suppliers();
			BeanUtils.populate(supplier, req.getParameterMap());
			// khởi tạo DAO
			Suppliers oldsupplier = suppliersService.findBySupplierId(supplier.getSupplierid());
			// xử lý hình ảnh
			if (req.getPart("images").getSize() == 0) {
				supplier.setImages(oldsupplier.getImages());
			} else {
				if (oldsupplier.getImages() != null) {
					// XOA ANH CU DI
					String fileName = oldsupplier.getImages();
					File file = new File(Constant.DIR+"\\suppliers\\" + fileName);
					if (file.delete()) {
						System.out.println("Đã xóa thành công");
					}else {
						System.out.println(Constant.DIR+"\\suppliers\\" + fileName);
					}
				}
				String fileName = supplier.getSuppliername() + System.currentTimeMillis();
				supplier.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\suppliers\\", fileName));
			}
		
		
			// khai báo danh sách và gọi hàm update trong service

			suppliersService.updateSupplier(supplier);

			// thông báo
			req.setAttribute("supplier", supplier);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void deleteSupplier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			// lấy dữ liệu trong jsp
			String supplierid = req.getParameter("supplierid");

			suppliersService.deleteSupplier(Integer.parseInt(supplierid));

			// thông báo
			req.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

}
