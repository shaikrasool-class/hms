package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.MedicineCategory;

public interface MedicineCategoryDao {
	
	public MedicineCategory createMedicineCategory(MedicineCategory medicineCategory);
	
	public MedicineCategory updateMedicineCategory(MedicineCategory medicineCategory);
	
	public MedicineCategory getMedicineCategory(Integer medId);
	
	public MedicineCategory deleteMedicineCategory(Integer medId);
	
	public List<MedicineCategory> getAllMedicineCategories();

	
}
