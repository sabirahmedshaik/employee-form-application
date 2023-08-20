package com.employee.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.employee.search.SearchEmployee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empid = Integer.parseInt( request.getParameter("empid"));
		String empName = request.getParameter("empName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String bloodGroup = request.getParameter("bloodGroup");
		int experience = Integer.parseInt(request.getParameter("experience"));
		String contactNo = request.getParameter("contactNo");
		
		String sql = "update employee set empName=?, dateOfBirth=?, bloodGroup=?, experience=?, contactNo=? where empid=?";
		String url = "jdbc:mysql://localhost:3306/emp";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empName);
			ps.setString(2, dateOfBirth);
			ps.setString(3, bloodGroup);
			ps.setInt(4, experience);
			ps.setString(5, contactNo);
			ps.setInt(6, empid);
			int executeUpdate = ps.executeUpdate();
			con.close();
		} catch (Exception e3) {
			System.out.println(e3); 
		}
		
		response.sendRedirect("update.jsp");
	}
}
