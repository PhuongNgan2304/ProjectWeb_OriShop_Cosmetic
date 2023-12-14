package vn.iotstar.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.DAO.UsersDAO.UsersDAO_Impl;
import vn.iotstar.Entity.Users;
import vn.iotstar.DAO.UsersDAO.IUsersDAO;


@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

	    private static final long serialVersionUID = -880838492723662096L;

		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	    }
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
	         //request.getRequestDispatcher("/decorators/Login.jsp").forward(request, response);
	    	request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	    }   
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //processRequest(request, response);
	        String user = request.getParameter("user");
	        String pass = request.getParameter("pass");
	        
	        System.out.println("Username: "+user);
	        System.out.println("Password: "+pass);
	        
	        IUsersDAO LoginDao= new UsersDAO_Impl() ;
	        Users a = LoginDao.login(user, pass);
	        if (a == null) {
	            request.setAttribute("mess", "wrong username or password");
	            //request.getRequestDispatcher("/decorators/Login.jsp").forward(request, response);
	            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	        } else {
	        	boolean is_admin=a.isAdmin();
	        	if(is_admin==true) {
	        		HttpSession session = request.getSession();
	        		session.setAttribute("acc", a);
	        		Cookie u=new Cookie("user",user);
	        		Cookie p=new Cookie("pass",pass);
	        		u.setMaxAge(60);
	        		p.setMaxAge(60);
	        		response.addCookie(u);
	        		response.addCookie(p);
	        		response.sendRedirect("admin-product_types");}
	        	else {
	        		
	        		HttpSession session = request.getSession();
	        		session.setAttribute("userid", a.getUserID());
	        		session.setAttribute("acc", a);
	        		Cookie u=new Cookie("user",user);
	        		Cookie p=new Cookie("pass",pass);
	        		u.setMaxAge(60);
	        		p.setMaxAge(60);
	        		response.addCookie(u);
	        		response.addCookie(p);
	        		response.sendRedirect("home");
	        	}
	    }
	    }
}
