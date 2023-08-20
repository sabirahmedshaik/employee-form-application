package com.employee.search;

import java.io.IOException;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import com.employee.update.Update;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt( request.getParameter("empid"));
		EmployeeDao dao = new EmployeeDao();
		Employee e = dao.getEmployee(empid);
		
		request.setAttribute("emp", e);
		if(e.getEmployeeID() == empid) {
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("notFound.jsp");
		}
		
		
	}
}
