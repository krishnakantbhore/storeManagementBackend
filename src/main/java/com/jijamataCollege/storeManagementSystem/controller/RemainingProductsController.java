package com.jijamataCollege.storeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jijamataCollege.storeManagementSystem.Entity.RemainingProducts;
import com.jijamataCollege.storeManagementSystem.dao.RemaingProductsDao;
import com.jijamataCollege.storeManagementSystem.service.RemainingProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/",allowCredentials = "true")
public class RemainingProductsController {

	@Autowired
	RemaingProductsDao remainingProductDao;
	
	@Autowired
	RemainingProductService remainingProductService;
	
	
	@GetMapping("getAllData")
	public List<RemainingProducts> getAllData(){
	  return remainingProductDao.findAll();	
	}
	
	@GetMapping("remainingProductsGetById")
	public RemainingProducts getBiId(@RequestParam int id) {
		return remainingProductService.getById(id);
	}
	
//	@PostMapping("updateRemainingProducts")
//	public String updateRemainingProducts(@RequestBody RemainingProducts products) {
//		remainingProductService.updateRemainingProducts(products);
//		return null;
//	}
}
