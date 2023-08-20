package com.employee.test.exception;

import com.employee.model.Employee;

public class EmployeeValidation{
	
	public void checkEmployee(Employee e, int empId) throws Exception{
		if(e.getEmployeeID() != empId) {
			throw new Exception("User details not Found");
		}
		else {
			throw new Exception("User details already exits");
		}
	}
	
	
	
	
																
}
