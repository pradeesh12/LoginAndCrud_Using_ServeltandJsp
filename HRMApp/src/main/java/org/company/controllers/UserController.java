package org.company.controllers;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.company.dao.UserDao;
import org.company.entities.User;

@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao=new UserDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(name);
		user.setPassword(password);
		if(dao.validateUser(user))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Invalid User Creditials");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
