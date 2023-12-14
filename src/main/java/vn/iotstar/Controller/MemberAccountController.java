package vn.iotstar.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.Entity.Users;
import vn.iotstar.Service.Users.IUsersService;
import vn.iotstar.Service.Users.UsersServiceImpl;
import vn.iotstar.Util.Constant;
import vn.iotstar.Util.UploadUtils;

@WebServlet(name = "MemberAccountController", urlPatterns = {"/member-myaccount"})
public class MemberAccountController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2924027054038605640L;
	IUsersService userService = new UsersServiceImpl();
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

    }

    
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
//         request.getRequestDispatcher("/decorators/Login.jsp").forward(request, response);
		request.getRequestDispatcher("/views/web/editUser.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    				updateUsers(req, resp);
    	resp.sendRedirect("home");
	}

	private void updateUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils

			Users user=new Users();
			BeanUtils.populate(user, req.getParameterMap());
			
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
						System.out.println("Đã  thành công");
					}else {
						System.out.println(Constant.DIR+"\\users\\" + fileName);
					}
				}
				String fileName =user.getImages() + System.currentTimeMillis();
				user.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"\\users\\", fileName));
			}
		
			userService.updateUser(user);
			// khai báo danh sách và g ?i hàm update trong service
			
			
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
}
