package com.rest.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicine_Id;

	private String name;
	
	private String medicine_Category;

	private String description;

	private Double price;

	private int quantity;

	private String manufacture_Company;

	

	public int getMedicine_Id() {
		return medicine_Id;
	}

	public void setMedicine_Id(int medicine_Id) {
		this.medicine_Id = medicine_Id;
	}

	public String getMedicine_Category() {
		return medicine_Category;
	}

	public void setMedicine_Category(String medicine_Category) {
		this.medicine_Category = medicine_Category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getManufacture_Company() {
		return manufacture_Company;
	}

	public void setManufacture_Company(String manufacture_Company) {
		this.manufacture_Company = manufacture_Company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
