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

import vn.iotstar.Service.Users.IUsersService;
import vn.iotstar.Service.Users.UsersServiceImpl;
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

import vn.iotstar.Entity.Users;

@MultipartConfig

@WebServlet(urlPatterns = { "/admin-users", "/admin-users/create", "/admin-users/update","/admin-users/delete","/admin-users/edit"
		})
public class ADMIN_UserController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService userService = new UsersServiceImpl();
	 
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		Users user = null;

		if (url.contains("delete")) {
			deleteUsersbyID(req, resp);
			user = new Users();
			req.setAttribute("user", user);
		} else if (url.contains("edit")) {
			editUser(req, resp);
		} else if (url.contains("reset")) {
			user = new Users();
			req.setAttribute("user", user);
		}

		// g�?i hàm findAll để lấy thông tin từ entity

		findAllUser(req, resp);
		req.setAttribute("tag", "user");
		req.getRequestDispatcher("/views/admin/Users/list.jsp").forward(req, resp);
		
	}
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
		// lấy url
				String url = req.getRequestURL().toString();
				// kiểm tra url rồi chuyển đến hàm tương ứng
				if (url.contains("create")) {
					SignUp(req, resp);
				} else if (url.contains("update")) {
					updateUsers(req, resp);
				} else if (url.contains("delete")) {
					deleteUsersbyID(req, resp);
				} else if (url.contains("reset")) {
					req.setAttribute("user", new Users());
				}
				// g�?i hàm findAll để lấy thông tin từ entity
				findAllUser(req, resp);
				req.getRequestDispatcher("/views/admin/Users/list.jsp").forward(req, resp);
	}


	private void SignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// kh�?i tạo đối tượng Model
			Users user = new Users();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(user, req.getParameterMap());
			// xử lý hình ảnh
			String fileName = user.getImages()+ System.currentTimeMillis();
			user.setImages(UploadUtils.processUpload("images", req, Constant.DIR + "\\users\\", fileName));

			// g�?i hàm insert để thêm dữ liệu
			// category.setStatus(true);
			userService.signup(user);
			// thông báo
			req.setAttribute("message", "�?ã thêm thành công");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		// TODO Auto-generated method stub
	
	}
	private void updateUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			Users  user = new Users();
			BeanUtils.populate(user, req.getParameterMap());
			// khởi tạo DAO
			Users olduser = userService.findByUserId(user.getUserID());
			// xử lý hình ảnh
			if (req.getPart("images").getSize() == 0) {
				user.setImages(olduser.getImages());
			} else {
				if (olduser.getImages() != null) {
					// XOA ANH CU DI
					String fileName = olduser.getImages();
					File file = new File(Constant.DIR+"\\users\\" + fileName);
					if (file.delete()) {
						System.out.println("�?ã xóa thành công");
					}else {
						System.out.println(Constant.DIR+"\\users\\" + fileName);
					}
				}
				String fileName =user.getImages() + System.currentTimeMillis();
				user.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\users\\", fileName));
			}
		
		
			// khai báo danh sách và g�?i hàm update trong service

			userService.updateUser(user);

			// thông báo
			req.setAttribute("user", user);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
		private void deleteUsersbyID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				// lấy dữ liệu trong jsp
				int userid= Integer.parseInt(req.getParameter("userID"));

				userService.deleteUser(userid);
				
				// thông báo
				req.setAttribute("message", "�?ã xóa thành công");

			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "Eror: " + e.getMessage());
			}
		}
		
		private void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				List<Users> list = userService.getAllUsers();

				// thông báo
				req.setAttribute("users", list);

			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "Eror: " + e.getMessage());
			}
		}
		private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				int userid= Integer.parseInt(req.getParameter("userID"));
				Users user = userService.findByUserId(userid);
				
				// thông báo
				req.setAttribute("user", user);

			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "Eror: " + e.getMessage());
			}
		}
	}
