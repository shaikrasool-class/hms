package com.rest.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pharmacist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phId;
	private String name;
	private String email;
	private String address;
	private int phone;
	public int getPhId() {
		return phId;
	}
	public void setPhId(int phId) {
		this.phId = phId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
