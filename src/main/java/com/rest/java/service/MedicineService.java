package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.MedicineDto;
import com.rest.java.entity.Medicine;

public interface MedicineService extends BaseDao<MedicineDto, Medicine>{
	
	public MedicineDto createMedicine(MedicineDto dto);
	
	public MedicineDto updateMedicine(MedicineDto dto);
	
	public MedicineDto getOneMedicineById(Integer medicine_Id);
	
	public MedicineDto deleteMedicine(Integer medicine_Id);
	
	public List<MedicineDto> getAllMedicines();

}
