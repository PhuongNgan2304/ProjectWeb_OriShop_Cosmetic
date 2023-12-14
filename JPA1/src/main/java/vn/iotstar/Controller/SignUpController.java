package vn.iotstar.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.UsersDAO.UsersDAO_Impl;
import vn.iotstar.Entity.Users;
import vn.iotstar.DAO.UsersDAO.IUsersDAO;


@WebServlet(name = "SignUpController", urlPatterns = {"/signup"})
public class SignUpController extends HttpServlet{

	private static final long serialVersionUID = 448617540294261961L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
//         request.getRequestDispatcher("/decorators/Login.jsp").forward(request, response);
    	request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass=request.getParameter("re_pass");
        String phone=request.getParameter("phone");
        String fullname=request.getParameter("fullname");
        String email=request.getParameter("email");
        String images=request.getParameter("images");
        
        System.out.println("User: "+user);
        System.out.println("Pass: "+pass);
        
        IUsersDAO  SignupDao= new UsersDAO_Impl() ;
        if(!pass.equals(re_pass)){
        	System.out.println("asfsdf");
            //response.sendRedirect("Login.jsp");
            response.sendRedirect("/login");

        } else {
            Users a = SignupDao.findByEmail(email);
            if(a==null) {
            	
            	Users newuser=new Users();
            	newuser.setUsername(user);
            	newuser.setPassword(pass);
            	newuser.setPhone(phone);
            	newuser.setFullname(fullname);
            	newuser.setActive(true);
            	newuser.setAdmin(false);
            	newuser.setEmail(email);
            	newuser.setImages(images);
            	SignupDao.SignUp(newuser);
            	response.sendRedirect("login");
            }else {
            		request.setAttribute("mess", "trung");
            		  response.sendRedirect("login");
            	}
            }
           
        }
    
}
