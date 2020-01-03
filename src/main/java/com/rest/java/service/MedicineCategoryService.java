package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.MedicineCategoryDto;
import com.rest.java.entity.MedicineCategory;

public interface MedicineCategoryService extends BaseDao<MedicineCategoryDto, MedicineCategory> {

	public MedicineCategoryDto createMedicineCategory(MedicineCategoryDto dto);
	
	public MedicineCategoryDto updateMedicineCategory(MedicineCategoryDto dto);
	
	public MedicineCategoryDto getMedicineCategory(Integer medId);
	
	public MedicineCategoryDto deleteMedicineCategory(Integer mediId);
	
	public List<MedicineCategoryDto> getAllCategoryDtos();
	
	
}
