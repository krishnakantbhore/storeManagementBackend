package com.jijamataCollege.storeManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jijamataCollege.storeManagementSystem.Entity.Outword;

@Repository
public interface OutwordDao extends JpaRepository<Outword, Integer> {

	public List<Outword> findByDate(String date);
	
	@Query("from Outword o where o.teacherName = :teacherName ORDER BY o.id DESC")
	public List<Outword> findByTeacherName(String teacherName);
	
	
}
