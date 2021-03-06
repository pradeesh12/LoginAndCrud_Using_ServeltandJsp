package org.company.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.entities.Emp;
import org.company.service.EmployeeService;
import org.company.service.EmployeeServiceImpl;

@WebServlet("/employess")
public class DisplayEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeService empser=new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Emp> emp=empser.getEmployees();
	        request.setAttribute("employees", emp);
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	        rd.forward(request, response);
	}

}
