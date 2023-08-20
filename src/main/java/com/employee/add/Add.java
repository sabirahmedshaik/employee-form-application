package com.employee.add;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import com.employee.test.exception.EmployeeValidation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt( request.getParameter("empid"));
		String empName = request.getParameter("empName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String bloodGroup = request.getParameter("bloodGroup");
		int experience = Integer.parseInt(request.getParameter("experience"));
		String contactNo = request.getParameter("contactNo");
		
		EmployeeDao dao = new EmployeeDao();
		Employee e = dao.getEmployee(empid);
		EmployeeValidation validate = new EmployeeValidation();
		try {
			validate.checkEmployee(e, empid);
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
		
		String sql = "insert into employee values("+empid+", + '"+empName+"', + '"+dateOfBirth+"', + '"+bloodGroup+"', "+ experience+", + '"+contactNo+"')";
		String url = "jdbc:mysql://localhost:3306/emp";
		String username = "root";
		String password = "";
		if(e.getEmployeeID() != empid)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				int executeUpdate = st.executeUpdate(sql);
				con.close();
			} catch (Exception e3) {
				System.out.println(e3);
			}
			
			response.sendRedirect("added.jsp");
		}
		else
		{
			response.sendRedirect("found.jsp");
		}
	}

}
