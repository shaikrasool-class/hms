package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Pharmacist;

public interface PharmacistDao {

	public Pharmacist addPharmacist(Pharmacist pharmacist);
	
	public Pharmacist updatePharmacist(Pharmacist pharmacist);
	
	public Pharmacist getOnePharmacist(Integer phId);
	
	public Pharmacist deletePharmacist(Integer phId);
	
	public List<Pharmacist> getPharmacists();
}
