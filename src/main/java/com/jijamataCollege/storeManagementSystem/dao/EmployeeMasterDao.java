package com.jijamataCollege.storeManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jijamataCollege.storeManagementSystem.Entity.EmployeeMaster;

@Repository
public interface EmployeeMasterDao extends JpaRepository<EmployeeMaster, Integer> {

	
	
	List<EmployeeMaster> findByEmployeeDepartment(String employeeDepartment);

	@Query("SELECT DISTINCT o.employeeName from EmployeeMaster o")
	List<String> findOnlyTeacherName();
	
	@Query("SELECT DISTINCT o.employeeName from EmployeeMaster o where employeeDepartment= :employeeDepartment")
	List<String> findTeacherNameByDepartment(String employeeDepartment);
	
	 
}
