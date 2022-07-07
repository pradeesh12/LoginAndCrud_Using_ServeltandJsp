package org.company.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.service.EmployeeService;
import org.company.service.EmployeeServiceImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   EmployeeService service=new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eno=Integer.parseInt(request.getParameter("eno"));
		System.out.println(eno);
		service.deleteEmployee(eno);
		response.sendRedirect("./employess");
	}

}
