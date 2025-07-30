package com.jijamataCollege.storeManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.jijamataCollege.storeManagementSystem.Entity.Inword;

@Repository
public interface InwordDao extends JpaRepository<Inword,Integer> {
	
//	@Query("from Inword where stockName = :stockName ")
//	List<Inword> getBystockName(@Param("stockName") String stockName);

	List<Inword> findByStockName(String stockName);
	
	List<Inword> findByDate(String date);
	 
}
