package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellerDao;
import dto.SellerDto;

@WebServlet("/signup")
public class SignUp extends HttpServlet
{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        long contact = Long.parseLong(req.getParameter("contact"));
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        
        SellerDto seller = new SellerDto();
        seller.setId(id);
        seller.setContact(contact);
        seller.setEmail(email);
        seller.setName(name);
        seller.setPassword(pass);
        
        SellerDao dao = new SellerDao();
        try {
			int res = dao.saveSeller(seller);
			if(res==1)
			{
				req.setAttribute("message", "signup sucess");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
			
			else
			{
				req.setAttribute("message", "signup failed");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}

