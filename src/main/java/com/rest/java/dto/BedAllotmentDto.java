package com.rest.java.dto;

import java.sql.Date;

public class BedAllotmentDto {
	
	private int bedId;
	
	private String bedNumber;
	
	private Date allotmentDate;
	
	private Date dischargeDate;
	
	private String patientName;
	

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getBedId() {
		return bedId;
	}
	public void setBedId(int bedId) {
		this.bedId = bedId;
	}
	public String getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	
	public Date getAllotmentDate() {
		return allotmentDate;
	}
	public void setAllotmentDate(Date allotmentDate) {
		this.allotmentDate = allotmentDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	
	
	
}
