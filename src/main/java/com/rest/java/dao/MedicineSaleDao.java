package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.MedicineSale;

public interface MedicineSaleDao {
	
	public MedicineSale createMedicineSale(MedicineSale medicine);
	
	public MedicineSale updMedicineSale(MedicineSale medicine);
	
	public MedicineSale getMedicineSale(Integer med_Id);
	
	public MedicineSale deleteMedicineSale(Integer med_Id);
	
	public List<MedicineSale> getAllMedicineSalse();
}
