package com.employee.delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt( request.getParameter("empid"));
		
		String sql = "delete from employee where empid=?";
		String url = "jdbc:mysql://localhost:3306/emp";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empid);
			int executeUpdate = ps.executeUpdate();
			con.close();
		} catch (Exception e3) {
			System.out.println(e3); 
		}
		
		response.sendRedirect("delete.jsp");
	}
}
