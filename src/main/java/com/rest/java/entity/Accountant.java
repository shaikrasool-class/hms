package com.rest.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accountant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acId;
	private String name;
	private String email;
	private int phone;
	private String address;
	
	public int getAcId() {
		return acId;
	}
	public void setAcId(int acId) {
		this.acId = acId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
