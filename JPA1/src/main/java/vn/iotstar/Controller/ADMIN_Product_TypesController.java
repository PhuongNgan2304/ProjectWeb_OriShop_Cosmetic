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
import javax.servlet.http.Part;

import vn.iotstar.Entity.Product_Types;
import vn.iotstar.Service.Product_Types.IProduct_TypesService;
import vn.iotstar.Service.Product_Types.Product_TypesServiceImpl;
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-product_types", "/admin-product_types/create", "/admin-product_types/update",
		"/admin-product_types/edit", "/admin-product_types/delete", "/admin-product_types/reset" })

public class ADMIN_Product_TypesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IProduct_TypesService product_typesService = new Product_TypesServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Product_Types type = null;

		if (url.contains("delete")) {
			deleteType(req, resp);
			type = new Product_Types();
			req.setAttribute("type", type);

		} else if (url.contains("edit")) {
			editType(req, resp);

		} else if (url.contains("reset")) {
			type = new Product_Types();
			req.setAttribute("type", type);
		}

		// gọi hàm findAll để lấy thông tin từ entity

		findAllTypes(req, resp);
		req.setAttribute("tag", "type");
		req.getRequestDispatcher("/views/admin/Product_Types/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lấy url
		String url = req.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("create")) {
			insertType(req, resp);
		} else if (url.contains("update")) {
			updateType(req, resp);
		} else if (url.contains("delete")) {
			deleteType(req, resp);
		} else if (url.contains("reset")) {
			req.setAttribute("type", new Product_Types());
		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAllTypes(req, resp);
		req.getRequestDispatcher("/views/admin/Product_Types/list.jsp").forward(req, resp);
	}

	private void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Product_Types> list = product_typesService.findAllType();

			// thông báo
			req.setAttribute("types", list);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void editType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String typeid = req.getParameter("typeid");

			Product_Types type = product_typesService.findByTypeId(Integer.parseInt(typeid));
			// thông báo
			req.setAttribute("type", type);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void deleteType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// lấy dữ liệu trong jsp
			String typeid = req.getParameter("typeid");

			product_typesService.deleteType(Integer.parseInt(typeid));

			// thông báo
			req.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void insertType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			Product_Types type = new Product_Types();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(type, req.getParameterMap());
			// xử lý hình ảnh
			String fileName = type.getTypecode() + System.currentTimeMillis();
			type.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\types\\", fileName));

			// gọi hàm insert để thêm dữ liệu
			// category.setStatus(true);
			product_typesService.insertType(type);
			// thông báo
			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}

	}

	private void updateType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			Product_Types type = new Product_Types();
			BeanUtils.populate(type, req.getParameterMap());
			// khởi tạo DAO
			Product_Types oldtype = product_typesService.findByTypeId(type.getTypeid());
			// xử lý hình ảnh
			if (req.getPart("images").getSize() == 0) {
				type.setImages(oldtype.getImages());
			} else {
				if (oldtype.getImages() != null) {
					// XOA ANH CU DI
					String fileName = oldtype.getImages();
					File file = new File(Constant.DIR+"\\types\\" + fileName);
					if (file.delete()) {
						System.out.println("Đã xóa thành công");
					}else {
						System.out.println(Constant.DIR+"\\types\\" + fileName);
					}
				}
				String fileName = type.getTypecode() + System.currentTimeMillis();
				type.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\types\\", fileName));
			}
		
		
			// khai báo danh sách và gọi hàm update trong service

			product_typesService.updateType(type);

			// thông báo
			req.setAttribute("type", type);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
	
