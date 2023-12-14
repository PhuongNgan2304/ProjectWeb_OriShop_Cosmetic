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
import vn.iotstar.Entity.Skins;
import vn.iotstar.Service.Skins.ISkinsService;
import vn.iotstar.Service.Skins.SkinsServiceImpl;
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-skins", "/admin-skins/create", "/admin-skins/update", "/admin-skins/edit",
		"/admin-skins/delete", "/admin-skins/reset" })
public class ADMIN_SkinsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// IProduct_TypesService product_typesService = new Product_TypesServiceImpl();
	ISkinsService skinsService = new SkinsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Skins skin = null;

		if (url.contains("delete")) {
			deleteSkin(req, resp);
			skin = new Skins();
			req.setAttribute("skin", skin);

		} else if (url.contains("edit")) {
			editSkin(req, resp);

		} else if (url.contains("reset")) {
			skin = new Skins();
			req.setAttribute("skin", skin);
		}

		findAllSkins(req, resp);
		req.setAttribute("tag", "skin");
		req.getRequestDispatcher("/views/admin/Skins/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lấy url
		String url = req.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("create")) {
			insertSkin(req, resp);
		} else if (url.contains("update")) {
			updateSkin(req, resp);
		} else if (url.contains("delete")) {
			deleteSkin(req, resp);
		} else if (url.contains("reset")) {
			req.setAttribute("type", new Skins());
		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAllSkins(req, resp);
		req.getRequestDispatcher("/views/admin/Skins/list.jsp").forward(req, resp);
	}

	private void findAllSkins(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Skins> list = skinsService.findAllSkin();

			// thông báo
			req.setAttribute("skins", list);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void editSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			String skinid = req.getParameter("skinid");

			Skins skin = skinsService.findBySkinId(Integer.parseInt(skinid));
			// thông báo
			req.setAttribute("skin", skin);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void deleteSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			// lấy dữ liệu trong jsp
			String skinid = req.getParameter("skinid");

			skinsService.deleteSkin(Integer.parseInt(skinid));

			// thông báo
			req.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void updateSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			Skins skin = new Skins();
			BeanUtils.populate(skin, req.getParameterMap());
			// khởi tạo DAO
			Skins oldskin = skinsService.findBySkinId(skin.getSkinid());
			// xử lý hình ảnh
			if (req.getPart("images").getSize() == 0) {
				skin.setImages(oldskin.getImages());
			} else {
				if (oldskin.getImages() != null) {
					// XOA ANH CU DI
					String fileName = oldskin.getImages();
					File file = new File(Constant.DIR+"\\skins\\" + fileName);
					if (file.delete()) {
						System.out.println("Đã xóa thành công");
					}else {
						System.out.println(Constant.DIR+"\\skins\\" + fileName);
					}
				}
				String fileName = skin.getSkinname() + System.currentTimeMillis();
				skin.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\skins\\", fileName));
			}
		
		
			// khai báo danh sách và gọi hàm update trong service

			skinsService.updateSkin(skin);

			// thông báo
			req.setAttribute("skin", skin);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void insertSkin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			Skins skin = new Skins();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(skin, req.getParameterMap());
			// xử lý hình ảnh
			String fileName = skin.getSkinname() + System.currentTimeMillis();
			skin.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\skins\\", fileName));

			// gọi hàm insert để thêm dữ liệu
			// category.setStatus(true);
			skinsService.insertSkin(skin);
			// thông báo
			req.setAttribute("message", "Đã thêm thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

}
