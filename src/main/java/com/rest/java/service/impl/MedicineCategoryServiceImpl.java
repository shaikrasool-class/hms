package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.MedicineCategoryDao;
import com.rest.java.dto.MedicineCategoryDto;
import com.rest.java.entity.MedicineCategory;
import com.rest.java.service.MedicineCategoryService;

@Service
public class MedicineCategoryServiceImpl implements MedicineCategoryService{

	@Autowired
	private MedicineCategoryDao medicineCategoryDao;
	@Override
	public MedicineCategoryDto createMedicineCategory(MedicineCategoryDto dto) {
		MedicineCategory medicine=mapDtoToEntity(dto);
		medicine=medicineCategoryDao.createMedicineCategory(medicine);
		MedicineCategoryDto medicineDto=mapEntityToDto(medicine);
		return medicineDto;
	}

	@Override
	public MedicineCategoryDto updateMedicineCategory(MedicineCategoryDto dto) {
		MedicineCategory medicine=mapDtoToEntity(dto);
		medicine=medicineCategoryDao.updateMedicineCategory(medicine);
		MedicineCategoryDto medicineDto=mapEntityToDto(medicine);
			return medicineDto;
	}

	@Override
	public MedicineCategoryDto getMedicineCategory(Integer medId) {
		MedicineCategory medicine=medicineCategoryDao.getMedicineCategory(medId);
		MedicineCategoryDto dto=mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public MedicineCategoryDto deleteMedicineCategory(Integer mediId) {
		MedicineCategory medicine=medicineCategoryDao.deleteMedicineCategory(mediId);
		MedicineCategoryDto dto=mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public List<MedicineCategoryDto> getAllCategoryDtos() {
		List<MedicineCategory> medicine=medicineCategoryDao.getAllMedicineCategories();
		List<MedicineCategoryDto> dtos=mapEntitiesToDto(medicine.iterator());
		for(int i=0; i<medicine.size(); i++) {
			MedicineCategoryDto dto=new MedicineCategoryDto();
			BeanUtils.copyProperties(medicine.get(i), dto);
		}
		
 		return dtos;
	}
	
	private List<MedicineCategoryDto> mapEntitiesToDto(Iterator<MedicineCategory> medicineList) {
		List<MedicineCategoryDto> dtos=null;
		if(medicineList!=null) {
			dtos=new ArrayList<MedicineCategoryDto>();
			while(medicineList.hasNext()) {
				dtos.add(mapEntityToDto(medicineList.next()));
			}
		}
		return dtos;
	}

	@Override
	public MedicineCategory mapDtoToEntity(MedicineCategoryDto dto) {
		MedicineCategory entity=new MedicineCategory();
		entity.setMedId(dto.getMedId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		return entity;
	}

	@Override
	public MedicineCategoryDto mapEntityToDto(MedicineCategory entity) {
			MedicineCategoryDto dto=new MedicineCategoryDto();
			dto.setMedId(entity.getMedId());
			dto.setName(entity.getName());
			dto.setDescription(entity.getDescription());
		return dto;
	}


	

}
