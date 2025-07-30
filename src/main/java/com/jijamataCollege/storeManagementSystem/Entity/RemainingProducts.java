package com.jijamataCollege.storeManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RemainingProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String productName;
	int productQuantity;
	public RemainingProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RemainingProducts(int id, String productName, int productQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productQuantity = productQuantity;
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
	@Override
	public String toString() {
		return "RemainingProducts [id=" + id + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ "]";
	}
	
}
