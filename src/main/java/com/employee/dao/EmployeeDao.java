package com.employee.dao;

import com.employee.model.Employee;
import java.sql.*;
public class EmployeeDao {
	public Employee getEmployee(int empid) {
		
		Employee e = new Employee();
		
		String sql="select * from employee where empid="+empid;
		String url="jdbc:mysql://localhost:3306/emp";
		String username="root";
		String password="";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				e.setEmployeeID(rs.getInt("empid"));
				e.setEmployeeName(rs.getString("empName"));
				e.setDateOfBirth(rs.getString("dateOfBirth"));
				e.setBloodGroup(rs.getString("bloodGroup"));
				e.setExperience(rs.getInt("experience"));
				e.setContactNo(rs.getString("contactNo"));
			}
			st.close();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return e;
	}
	
}
