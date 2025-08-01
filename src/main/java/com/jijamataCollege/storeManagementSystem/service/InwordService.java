package com.jijamataCollege.storeManagementSystem.service;
 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jijamataCollege.storeManagementSystem.Entity.Inword;
import com.jijamataCollege.storeManagementSystem.Entity.RemainingProducts;
import com.jijamataCollege.storeManagementSystem.dao.InwordDao;
import com.jijamataCollege.storeManagementSystem.dao.RemaingProductsDao;

@Service
public class InwordService {

	@Autowired
	InwordDao inword;
	
	@Autowired
	RemaingProductsDao remaingProductsDao;
	
 
	public Inword saveData(Inword data) {
		
 
		
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String currDate=formater.format(date);
		
 
		data.setDate(currDate);
		
	 	RemainingProducts remaingProducts=new RemainingProducts();
       
		 
		
	 	Inword saveData = inword.save(data);
	 	
	 	List<RemainingProducts> remainingProductsList = remaingProductsDao.findByProductName(data.getStockName());
	 	
				if(!remainingProductsList.isEmpty()) {
					
					RemainingProducts newRemainingProducts = remainingProductsList.get(0);
					newRemainingProducts.setProductName(data.getStockName());
					newRemainingProducts.setProductQuantity(newRemainingProducts.getProductQuantity() +data.getStockQuantity());

					remaingProductsDao.save(newRemainingProducts);
					
				}else {
					remaingProducts.setProductName(data.getStockName());
					remaingProducts.setProductQuantity(data.getStockQuantity());
					remaingProductsDao.save(remaingProducts);
				}
				
			 
				
				if(saveData!=null)return saveData;
	        	return null;
		 
	}
	
	
	
	
	
	public List<Inword> getAlldata(String date){
		return inword.findByDate(date);
	}





	public Inword getDataById(int id) {
		return inword.findById(id).orElse(null);
		 
	}
	
	public Inword updateInwordData(Inword data) {
	    Inword inwordData = inword.findById(data.getStockId()).orElse(null);
	    List<RemainingProducts> remainingProductsList = remaingProductsDao.findByProductName(data.getStockName());

	    if (inwordData == null || remainingProductsList.isEmpty()) return null;

	    RemainingProducts newRemainingProducts = remainingProductsList.get(0);

	    // Store the original stock quantity before updating
	    int originalStockQuantity = inwordData.getStockQuantity();

	    // Update inword data
	    inwordData.setDate(data.getDate());
	    inwordData.setStockName(data.getStockName());
	    inwordData.setStockQuantity(data.getStockQuantity());

	    Inword saveData = inword.save(inwordData);

	    // Update remaining products
	    newRemainingProducts.setProductName(data.getStockName());

	    if (data.getStockQuantity() < originalStockQuantity) {
	        newRemainingProducts.setProductQuantity(
	            newRemainingProducts.getProductQuantity() - (originalStockQuantity - data.getStockQuantity())
	        );
	    } else {
	        newRemainingProducts.setProductQuantity(
	            newRemainingProducts.getProductQuantity() + (data.getStockQuantity() - originalStockQuantity)
	        );
	    }

	    remaingProductsDao.save(newRemainingProducts);

	    return saveData;
	}

	
}
