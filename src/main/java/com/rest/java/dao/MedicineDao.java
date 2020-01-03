package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Medicine;

public interface MedicineDao {

	public Medicine createMedicine(Medicine medicine);
	
	public Medicine updateMedicine(Medicine medicine);
	
	public Medicine getOneMedicineById(Integer medicine_Id);
	
	public Medicine deleteMedicine(Integer medicine_Id);
	
	public List<Medicine> getAllMedicine();
}
