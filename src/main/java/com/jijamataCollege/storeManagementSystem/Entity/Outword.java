package com.jijamataCollege.storeManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Outword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String productName;
	int productQuantity;
	String teacherName;
	String date;
	public Outword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Outword(int id, String productName, int productQuantity, String teacherName, String date) {
		super();
		this.id = id;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.teacherName = teacherName;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Outword [id=" + id + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ ", teacherName=" + teacherName + ", date=" + date + "]";
	}
	
	
	
	
}
