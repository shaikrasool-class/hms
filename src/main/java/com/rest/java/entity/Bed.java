package com.rest.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author root
 *
 */
@Entity
public class Bed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bed_Id;

	private String ward;

	private String bedType;

	private String description;

	private String bedNumber;
	
	public int getBed_Id() {
		return bed_Id;
	}

	public void setBed_Id(int bed_Id) {
		this.bed_Id = bed_Id;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	
	

	
}
