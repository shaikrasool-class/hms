package com.rest.java.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedicineSale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int med_Id;

	private String patientName;

	private Double price;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Medicine> medicines;

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

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

}
