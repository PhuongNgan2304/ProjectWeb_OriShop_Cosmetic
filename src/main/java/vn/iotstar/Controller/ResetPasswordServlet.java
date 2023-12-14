package vn.iotstar.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import vn.iotstar.Entity.Users;
import vn.iotstar.Service.Users.IUsersService;
import vn.iotstar.Service.Users.UsersServiceImpl;
import vn.iotstar.Util.Email;
 
/**
 * A Java Servlet to handle requests to reset password for customer
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/forgotPassword")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    IUsersService userService = new UsersServiceImpl();
 
    public ResetPasswordServlet() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	request.getRequestDispatcher("views/forgotPassword.jsp").forward(request, response);

    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		userService.resetCustomerPassword(email);
		Users user = userService.findByEmail(email);
		
		if(user.getEmail().equals(email)) {
			Email sm= new Email();
			boolean test = sm.EmailSend(user);
			if(test) {
				request.setAttribute("mesage", "Vui lòng kiểm tra mail để nhận mật khẩu mới");
			}
			else {
				request.setAttribute("error", "Lỗi gửi mail");
			}
			response.sendRedirect("login");
		
		}else {
			request.setAttribute("error", "Username hoặc email không tồn tại trong hệ thống");
			request.getRequestDispatcher("views/forgotPassword.jsp").forward(request, response);
			return;
		}
     


    }
    

 
}