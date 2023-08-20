package com.employee.viewAll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta .servlet.http.HttpServletResponse;


public class ViewAll extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print("<table border='1'><tr><th>Employee Id</th><th>Employee Name</th><th>Date of Birth</th><th>Blood Group</th><th>Experience</th><th>Contact no</th></tr>");
		String sql="select * from employee";
		String url="jdbc:mysql://localhost:3306/emp";
		String username="root";
		String password="";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				out.print("<tr><td>");
				out.print(rs.getInt("empid"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("empName"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("dateOfBirth"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("bloodGroup"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt("experience"));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString("contactNo"));
				out.print("</td>");
				out.print("</tr>");
			}
			st.close();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		out.print("</table>");
	}
	

}
