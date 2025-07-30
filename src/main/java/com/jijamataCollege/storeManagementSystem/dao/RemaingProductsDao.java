package com.jijamataCollege.storeManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jijamataCollege.storeManagementSystem.Entity.RemainingProducts;

@Repository
public interface RemaingProductsDao extends JpaRepository<RemainingProducts, Integer> {

	List<RemainingProducts> findByProductName(String productName);
}
