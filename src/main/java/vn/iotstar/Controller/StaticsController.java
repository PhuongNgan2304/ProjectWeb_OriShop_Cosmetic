package vn.iotstar.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.Order_User.IOrder_UserDAO;
import vn.iotstar.DAO.Order_User.Order_UserDAOImpl;

@WebServlet(urlPatterns = "/admin-Statics")
public class StaticsController  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2196648457829353047L;
	IOrder_UserDAO order_UserDAO = new Order_UserDAOImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			float totalPrice = order_UserDAO.revenuebyMonth(12);
			float earningannual = order_UserDAO.revenuebyYear(2023);
				
			int orderrequest = order_UserDAO.countOrder();
			req.setAttribute("earningmonthly", totalPrice);
			req.setAttribute("earningannual", earningannual);
			req.setAttribute("orderrequest", orderrequest);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/Statics/Revenue.jsp");
			rd.forward(req, resp);
		
	}

}
