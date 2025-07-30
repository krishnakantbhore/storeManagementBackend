package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.EmployeeMaster;
import com.jijamataCollege.storeManagementSystem.service.EmployeeMasterService;
import org.springframework.web.bind.annotation.RequestParam;

 

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class EmployeeMasterController {

	@Autowired
	EmployeeMasterService employeeMasterService;
	
	@GetMapping("employeeMaster")
	public String Test() {
		return "from employee master";
	}
	
	@PostMapping("saveEmployee")
	public String saveEmployee(@RequestBody EmployeeMaster employeeMaster) {
		return employeeMasterService.saveEmployee(employeeMaster);
		
	}
	
	@GetMapping("getByDepartment")
	public List<EmployeeMaster> getByDepartmentName(@RequestParam String departmentName) {
		return employeeMasterService.getByDepartment(departmentName);
	}
	
	@GetMapping("getAllEmployeeData")
	public List<EmployeeMaster> getAllEmployeeData(){
	return	employeeMasterService.getAllEmployeeData();
		 
	}
	
	@GetMapping("findTeacherName")
	public List<String> findAllTeacherName(){
		return employeeMasterService.findAllTeacherName();
	}
	
	
}
