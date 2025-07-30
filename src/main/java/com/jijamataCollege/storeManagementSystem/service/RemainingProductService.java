package com.jijamataCollege.storeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jijamataCollege.storeManagementSystem.Entity.RemainingProducts;
import com.jijamataCollege.storeManagementSystem.dao.RemaingProductsDao;

@Service
public class RemainingProductService {

	@Autowired
	RemaingProductsDao remainingProductDao;

	public RemainingProducts getById(int id) {
		return  remainingProductDao.findById(id).orElse(null);
	}

//	public  RemainingProducts updateRemainingProducts(RemainingProducts products) {
//		List<RemainingProducts> productByName = remainingProductDao.findByProductName(products.getProductName());
//		if(productByName.isEmpty()) return null;
//		
//		RemainingProducts first = productByName.getFirst();
//		first.setProductName(products.getProductName());
//		first.setProductQuantity(0);
//		  remainingProductDao.save(products);
//		 
//		return null;
//	}
}
