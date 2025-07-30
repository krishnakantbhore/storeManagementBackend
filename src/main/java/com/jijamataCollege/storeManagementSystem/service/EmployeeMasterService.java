package com.jijamataCollege.storeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jijamataCollege.storeManagementSystem.Entity.EmployeeMaster;
import com.jijamataCollege.storeManagementSystem.dao.EmployeeMasterDao;

@Service
public class EmployeeMasterService {
	
	@Autowired
	EmployeeMasterDao employeeMasterDao;
	
	
	public String saveEmployee(EmployeeMaster employeeMaster) {
		EmployeeMaster employee = employeeMasterDao.save(employeeMaster);
		if(employee==null) {
			return "save Unsuccessfully";
		}
		return "save successfully";
	}
	
	public List<EmployeeMaster> getByDepartment(String departmentName){
		return employeeMasterDao.findByEmployeeDepartment(departmentName);
	}

	public List<EmployeeMaster>  getAllEmployeeData() {
		 
		return employeeMasterDao.findAll();
		
	}

	public List<String> findAllTeacherName() {
		 
	 
		return employeeMasterDao.findOnlyTeacherName();
	}

}
