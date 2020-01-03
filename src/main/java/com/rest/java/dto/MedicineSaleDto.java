package com.rest.java.dto;

import java.util.List;

public class MedicineSaleDto {

	private int med_Id;
	
	private String patientName;
	
	private Double price;
	
	private List<MedicineDto> medicines;

	public int getMed_Id() {
		return med_Id;
	}

	public void setMed_Id(int med_Id) {
		this.med_Id = med_Id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<MedicineDto> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicineDto> medicines) {
		this.medicines = medicines;
	}

	
	
	
	
}
