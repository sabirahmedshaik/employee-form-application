package com.employee.model;

public class Employee {
	private int employeeID;
	private String employeeName;
	private String dateOfBirth;
	private String bloodGroup;
	private int experience;
	private String contactNo;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Employee ID :" + employeeID + "\n" + "Employee Name :" + employeeName + "\n" + "Date Of Birth :" + dateOfBirth
				+ "\n" + "Blood Group :" + bloodGroup + "\n" + "Experience :" + experience + "\n" + "Contact Number :" + contactNo;
	}
	
	
	
	
	
	
}
