package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.Outword;
import com.jijamataCollege.storeManagementSystem.service.OutwordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class OutwordController {
	
	@Autowired
	OutwordService outwordService;
	
	@PostMapping("saveOutwordData")
	public String saveData(@RequestBody Outword data) {
		Outword saveData = outwordService.saveData(data);
		if(saveData!=null)return "save successfully";
		return "please fill the currect data";
	}

	
	@GetMapping("getOutwordDataByDate")
	public List<Outword> findByDate(@RequestParam String date){
		return outwordService.findByDate(date);
	}
	
	@GetMapping("getOutwordDataByTeacherName")
	public List<Outword> findByName(@RequestParam String teacherName){
		return outwordService.findByTeacherName(teacherName);
	}
	
	@GetMapping("getOutwordReportByName")
	public List<Outword> outwordReport(@RequestParam String teacherName){
		return outwordService.findByTeacherNameReport(teacherName);
	}
	
	@GetMapping("getById")
	public Outword getByID(@RequestParam int id) {
		return outwordService.getById(id);
	}
	
	@PostMapping("updateOutwordData")
	public String updateData(@RequestBody Outword data) {
		System.out.println(data);
		Outword saveData = outwordService.updateOutword(data);
		if(saveData!=null)return "update successfully";
		return "please fill the currect data";
	}
	
	@GetMapping("deleteById")
	public String deleteById(@RequestParam int id) {
		return outwordService.deleteById(id);
		  
	}
	
	@GetMapping("findByDateReport")
	public List<Outword> findByDateReport(@RequestParam String date){
		return outwordService.findByDateOutwordReport(date);
	}
	
	@GetMapping("getOutwordDataByDeparment")
	public List<Outword> getOutwordDataByDeparment(@RequestParam String departmentName) {
		return outwordService.findByDepartmentName(departmentName);
	}
	
	
}
