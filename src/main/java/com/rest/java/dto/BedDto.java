package com.rest.java.dto;

/**
 * @author root
 *
 */
public class BedDto {

	private int bed_Id;
	
	private String ward;
	
	private int bedNumber;
	
	private String bedType;
	
	private String description;

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

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}
	
	
	
	
}
