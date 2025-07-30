package com.jijamataCollege.storeManagementSystem.service;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List; 
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jijamataCollege.storeManagementSystem.Entity.Inword;
import com.jijamataCollege.storeManagementSystem.Entity.Outword;
import com.jijamataCollege.storeManagementSystem.Entity.RemainingProducts;
import com.jijamataCollege.storeManagementSystem.dao.EmployeeMasterDao;
import com.jijamataCollege.storeManagementSystem.dao.InwordDao;
import com.jijamataCollege.storeManagementSystem.dao.OutwordDao;
import com.jijamataCollege.storeManagementSystem.dao.RemaingProductsDao;

@Service
public class OutwordService {

	@Autowired
	OutwordDao outwordDao;
	
	@Autowired
	InwordDao inwordDao;
	
	@Autowired
	RemaingProductsDao remaingProductDao;
	
	@Autowired
	EmployeeMasterDao employeeMasterDao;
	
	
	
	 
	
	
	public Outword saveData(Outword data) {
		LocalDateTime time=LocalDateTime.now();
	    DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String currDate=formater.format(time);
	    
	    data.setDate(currDate);
		 
		
		List<Inword> productList = inwordDao.findByStockName(data.getProductName());
		List<RemainingProducts> remaingProductList = remaingProductDao.findByProductName(data.getProductName());
		
		
		if(productList.isEmpty()) {
			return null;
		}
		else {
			RemainingProducts newRemainingProducts = remaingProductList.getFirst();
			if(newRemainingProducts.getProductQuantity()>=data.getProductQuantity()) {
				
				Outword outword=outwordDao.save(data);	
				if(!remaingProductList.isEmpty()) {
					
					
					newRemainingProducts.setProductName(data.getProductName());
					newRemainingProducts.setProductQuantity(newRemainingProducts.getProductQuantity()-data.getProductQuantity());

					remaingProductDao.save(newRemainingProducts);
					
				}
				
				
				
				 
				
				return outword;
			}
			
		}
		return null;
		
	
	}
	
	public List<Outword> findByDate(String date){
		return outwordDao.findByDate(date);
	}
	
	public List<Outword> findByDateOutwordReport(String date){
		List<Outword> listOfTeacherName=outwordDao.findByDate(date);
		Set<String> uniqProducts=new HashSet<>();
		List<Outword> totalData=new ArrayList<>();
		 	
		 for(Outword data : listOfTeacherName) {
				 uniqProducts.add(data.getProductName());
			 }
			List<String> uniqPrductsList=new ArrayList<>(uniqProducts);
			 
		    for(int i=0;i<uniqPrductsList.size();i++) {
			   int productQuantity=0;
		
			
			for(Outword data : listOfTeacherName) {
				
				if(data.getProductName().equals(uniqPrductsList.get(i))) 
				{
					
			      productQuantity+= data.getProductQuantity();
				}
		
			}
 
			 Outword outword=new Outword();
			 outword.setId(listOfTeacherName.get(i).getId());
			outword.setProductName(uniqPrductsList.get(i));
			outword.setProductQuantity(productQuantity);
//			 outword.setTeacherName(teacherName); 
			 outword.setDate(listOfTeacherName.get(i).getDate());
 
			 totalData.add(outword);
			
 
			
		 }
		 
		return totalData;
	}
	
	public List<Outword> findByTeacherName(String teacherName){
		 
		return outwordDao.findByTeacherName(teacherName);
	}
	
	public List<Outword> findByTeacherNameReport(String teacherName){
		
		List<Outword> listOfTeacherName=outwordDao.findByTeacherName(teacherName);
		Set<String> uniqProducts=new HashSet<>();
		List<Outword> totalData=new ArrayList<>();
		 	
		 for(Outword data : listOfTeacherName) {
				 uniqProducts.add(data.getProductName());
			 }
			List<String> uniqPrductsList=new ArrayList<>(uniqProducts);
			 
		    for(int i=0;i<uniqPrductsList.size();i++) {
			   int productQuantity=0;
		
			
			for(Outword data : listOfTeacherName) {
				
				if(data.getProductName().equals(uniqPrductsList.get(i))) 
				{
					
			      productQuantity+= data.getProductQuantity();
				}
		
			}
 
			 Outword outword=new Outword();
			 outword.setId(listOfTeacherName.get(i).getId());
			outword.setProductName(uniqPrductsList.get(i));
			outword.setProductQuantity(productQuantity);
			 outword.setTeacherName(teacherName); 
			 outword.setDate(listOfTeacherName.get(i).getDate());
 
			 totalData.add(outword);
			
 
			
		 }
		 
		return totalData;
	}
	
	
	
	
	
	public Outword getById(int id) {
			
		 return outwordDao.findById(id).orElse(null);
		 
	}

	public String deleteById(int id) {
		 Outword outword = getById(id);
		 if(outword==null) { return " can not be deleted Something went wrong";}
		 
		 outwordDao.delete(outword);
		       return "delete suceessfully";
	}
	
	
	
	public Outword updateOutword(Outword data) {
		 
		    Outword inwordData = outwordDao.findById(data.getId()).orElse(null);
		    List<RemainingProducts> remainingProductsList = remaingProductDao.findByProductName(data.getProductName());

		    if (inwordData == null || remainingProductsList.isEmpty()) return null;

		    RemainingProducts newRemainingProducts = remainingProductsList.getFirst();

		    // Store the original stock quantity before updating
		    int originalStockQuantity = inwordData.getProductQuantity();

		    // Update inword data
		    inwordData.setDate(data.getDate());
		    inwordData.setProductName(data.getProductName());
		    inwordData.setProductQuantity(data.getProductQuantity());
		    Outword saveData = outwordDao.save(inwordData);

		    // Update remaining products
		    newRemainingProducts.setProductName(data.getProductName());

		    if (data.getProductQuantity() < originalStockQuantity) {
		        newRemainingProducts.setProductQuantity(
		            newRemainingProducts.getProductQuantity() + (originalStockQuantity - data.getProductQuantity())
		        );
		    } else {
		        newRemainingProducts.setProductQuantity(
		            newRemainingProducts.getProductQuantity() - (data.getProductQuantity() - originalStockQuantity)
		        );
		    }

		    remaingProductDao.save(newRemainingProducts);

		    return saveData;
		}

	public List<Outword> findByDepartmentName(String departmentName) {
		List<String> teacherNameByDepartment = employeeMasterDao.findTeacherNameByDepartment(departmentName);
		System.out.println(teacherNameByDepartment);
		
		List<Outword> list=new ArrayList<>();
		for(String teacherName: teacherNameByDepartment) {
			List<Outword> listOfOutwordData = outwordDao.findByTeacherName(teacherName);
			
			for(Outword data: listOfOutwordData) {
				list.add(data);
			}
			
			
		}
		      
		 
		return list;
	}
		
	 
	
	
	
	
	
	
	
	
	
	
	
}
