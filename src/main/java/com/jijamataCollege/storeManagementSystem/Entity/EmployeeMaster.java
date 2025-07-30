package com.jijamataCollege.storeManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeMaster {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employeeid;
	
	String employeeName;
	String employeeAppointmentType;
	String employeeDepartment;
	String employeeDesignation;
	String employeeDevisionType;
	String employeeJoiningDate;
	String employeeMobileNumber;
	
	public EmployeeMaster(int employeeid, String employeeName, String employeeAppointmentType,
			String employeeDepartment, String employeeDesignation, String employeeDevisionType,
			String employeeJoiningDate, String employeeMobileNumber) {
		super();
		this.employeeid = employeeid;
		this.employeeName = employeeName;
		this.employeeAppointmentType = employeeAppointmentType;
		this.employeeDepartment = employeeDepartment;
		this.employeeDesignation = employeeDesignation;
		this.employeeDevisionType = employeeDevisionType;
		this.employeeJoiningDate = employeeJoiningDate;
		this.employeeMobileNumber = employeeMobileNumber;
	}

	public EmployeeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeID() {
		return employeeid;
	}

	public void setEmployeeID(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAppointmentType() {
		return employeeAppointmentType;
	}

	public void setEmployeeAppointmentType(String employeeAppointmentType) {
		this.employeeAppointmentType = employeeAppointmentType;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeDevisionType() {
		return employeeDevisionType;
	}

	public void setEmployeeDevisionType(String employeeDevisionType) {
		this.employeeDevisionType = employeeDevisionType;
	}

	public String getEmployeeJoiningDate() {
		return employeeJoiningDate;
	}

	public void setEmployeeJoiningDate(String employeeJoiningDate) {
		this.employeeJoiningDate = employeeJoiningDate;
	}

	public String getEmployeeMobileNumber() {
		return employeeMobileNumber;
	}

	public void setEmployeeMobileNumber(String employeeMobileNumber) {
		this.employeeMobileNumber = employeeMobileNumber;
	}

	@Override
	public String toString() {
		return "EmployeeMaster [employeeID=" + employeeid + ", employeeName=" + employeeName
				+ ", employeeAppointmentType=" + employeeAppointmentType + ", employeeDepartment=" + employeeDepartment
				+ ", employeeDesignation=" + employeeDesignation + ", employeeDevisionType=" + employeeDevisionType
				+ ", employeeJoiningDate=" + employeeJoiningDate + ", employeeMobileNumber=" + employeeMobileNumber
				+ "]";
	}
	
	
	
	
	
	
}
