<%@page import="com.employee.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style>

	*{
		margin: 0px;
		padding: 0px;
		box-sizing: border-box;
	}
	.container{
		width:60%;
		background-color: #0089ff;
		padding: 130px;
		margin: auto;
	}
	.button{
		display: block;
		width: 65%;
    	margin: 5px auto;
    	padding: 3px;
    	font-size: 13px;
    	border: 2px solid black;
    	border-radius: 6px;
		color: white;
    	background: purple;
   	 	padding: 8px 2px;
    	width: 62px;
    	cursor: pointer;
	}
	input{
		display: block;
		width: 65%;
    	margin: 5px auto;
    	padding: 3px;
    	font-size: 13px;
    	border: 2px solid black;
    	border-radius: 6px;
	}
	h3, h1{
		text-align: center;
	}
</style>
</head>
<body >
	<div class="container">
			<h1>Employee Details</h1>
			<p>______________________________________________________________</p>
			<br>
			<% 
				Employee e = (Employee)request.getAttribute("emp");
				out.println(e);
			%>
			
			<p>______________________________________________________________</p>
			<br>
			<h3>Update the user details with Employee Id :<%out.println(e.getEmployeeID()); %></h3>
			<br>
			<form action="Update">
				Enter Employee Id <input type="text" name="empid" > 
				Enter Employee Name <input type="text" name="empName" > 
				Enter Date of Birth <input type="text" name="dateOfBirth" > 
				Enter Blood group <input type="text" name="bloodGroup" > 
				Enter Experience <input type="text" name="experience"  >
				Enter Contact no. <input type="text" name="contactNo" >
				<input class="button" type="submit" value="update">
			</form>
			<p>______________________________________________________________</p>
			<br>
			<h3>Delete the user details with Employee Id :<%out.println(e.getEmployeeID()); %></h3>
			<br>
			<form action="Delete">
				Enter Employee Id <input type="text" name="empid" > 
				<input class="button" type="submit" value="delete">
			</form>
			<p>______________________________________________________________</p>
	</div>
</body>
</html>