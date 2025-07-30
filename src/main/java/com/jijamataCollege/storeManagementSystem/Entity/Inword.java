package com.jijamataCollege.storeManagementSystem.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inword {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stockId;
	String stockName;
	int stockQuantity;
	String date="";
	public Inword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inword(int stockId, String stockName, int stockQuantity, String date) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockQuantity = stockQuantity;
		this.date = date;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Inword [stockId=" + stockId + ", stockName=" + stockName + ", stockQuantity=" + stockQuantity
				+ ", date=" + date + "]";
	}
	
	
	
	
	
	
}
