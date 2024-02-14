package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.SellerDao;
import dto.SellerDto;

@WebServlet("/login")
public class Login extends HttpServlet
{
 @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
 {
	 String email = req.getParameter("email");
	 String pass = req.getParameter("password");
	 
	 SellerDao sdao = new SellerDao();
	 
	 SellerDto seller;
	try {
		seller = sdao.findByEmail(email);
		String name = seller.getName();
		if(seller!=null) 
		 {
			 
				 if(seller.getPassword().equals(pass))
				 {	 
					 HttpSession session = req.getSession();
					 session.setAttribute("email", email);
					 ProductDao dao = new ProductDao();
					 
					RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
					 dispatcher.include(req, resp);
				 }
			 
				 else 
				 {
					 req.setAttribute("message", "wrong password!");
					 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					 dispatcher.include(req, resp);
				 }
			 
		 }
		else 
		 {
			 req.setAttribute("message", "wrong email!");
			 RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			 dispatcher.include(req, resp);
		 }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
}
