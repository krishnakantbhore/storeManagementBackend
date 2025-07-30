package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.Inword;
import com.jijamataCollege.storeManagementSystem.service.InwordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/",allowCredentials = "true")
public class InwordController {

	@Autowired
	InwordService service;
	
	@GetMapping("/")
	public String home() {
		return "welcome to store in jijamata college";
	}
	
	@PostMapping("/saveInword")
	public ResponseEntity<String> saveData(@RequestBody Inword inword ) {
		 Inword saveData = service.saveData(inword);
		 
		 if(saveData!=null) return new ResponseEntity<String>("save successfully",HttpStatus.OK);
		 return new ResponseEntity<String>("data save Unsuccessfully",HttpStatus.BAD_REQUEST);
		 
	}
	
	
	@GetMapping("getAllInwordDataByDate")
	public List<Inword> getAllData(@RequestParam String date){
		return service.getAlldata(date);
	}
	
	@GetMapping("getInwordDataById")
	public Inword getInwordDataById(@RequestParam int  id) {
		return service.getDataById( id);
	}
	
	
	@PostMapping("/updateInword")
	public ResponseEntity<String> updateData(@RequestBody Inword inword ) {
		 Inword saveData = service.updateInwordData(inword);
		 
		 if(saveData!=null) return new ResponseEntity<String>("update successfully",HttpStatus.OK);
		 return new ResponseEntity<String>("data update Unsuccessfully",HttpStatus.BAD_REQUEST);
		 
	}
	
}
