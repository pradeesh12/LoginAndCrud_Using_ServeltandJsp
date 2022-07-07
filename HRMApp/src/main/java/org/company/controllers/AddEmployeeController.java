package org.company.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.entities.Emp;
import org.company.service.EmployeeService;
import org.company.service.EmployeeServiceImpl;

@WebServlet("/add")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service=new EmployeeServiceImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eno=Integer.parseInt(req.getParameter("eno"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		Emp e=new Emp(eno,name,address);
		service.insertEmployee(e);
		resp.sendRedirect("./employess");
	}

}
