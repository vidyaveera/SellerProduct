package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;

@WebServlet("/delete")
public class DeleteProduct extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	
      
    	int id = Integer.parseInt(req.getParameter("id"));
    	ProductDao dao = new ProductDao();	
    
    	try {
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			
			if(email!=null)
			{
				dao.deleteProduct(id);
				req.setAttribute("products", dao.getAll());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
			}	
			else
			{
				req.setAttribute("message", "login required!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
