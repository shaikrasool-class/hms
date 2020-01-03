package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.MedicineDao;
import com.rest.java.dto.MedicineDto;
import com.rest.java.entity.Medicine;
import com.rest.java.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public MedicineDto createMedicine(MedicineDto dto) {
		Medicine medicine = mapDtoToEntity(dto);
		medicine = medicineDao.createMedicine(medicine);
		return mapEntityToDto(medicine);
	}

	@Override
	public MedicineDto updateMedicine(MedicineDto dto) {
		Medicine medicine = mapDtoToEntity(dto);
		medicine = medicineDao.updateMedicine(medicine);
		return mapEntityToDto(medicine);
	}

	@Override
	public MedicineDto getOneMedicineById(Integer medicine_Id) {
		Medicine medicine = medicineDao.getOneMedicineById(medicine_Id);
		MedicineDto dto = mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public MedicineDto deleteMedicine(Integer medicine_Id) {
		Medicine medicine = medicineDao.deleteMedicine(medicine_Id);
		MedicineDto dto = mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public List<MedicineDto> getAllMedicines() {
		List<Medicine> medicines=medicineDao.getAllMedicine();
		List<MedicineDto> dtos=mapEntitiesToDtos(medicines.iterator());
		for(int i=0; i<medicines.size(); i++) {
			MedicineDto dto=new MedicineDto();
			BeanUtils.copyProperties(medicines.get(i), dto);
		}
		return dtos;
	}

	private List<MedicineDto> mapEntitiesToDtos(Iterator<Medicine> medicineList) {
		
		List<MedicineDto> dtos=null;
		if(medicineList!=null) {
			dtos=new ArrayList<MedicineDto>();
			while(medicineList.hasNext()) {
				dtos.add(mapEntityToDto(medicineList.next()));
			}
		}
		return dtos;
	}

	@Override
	public Medicine mapDtoToEntity(MedicineDto dto) {
		Medicine entity = new Medicine();
		entity.setMedicine_Id(dto.getMedicine_Id());
		entity.setName(dto.getName());
		entity.setMedicine_Category(dto.getMedicine_Category());
		entity.setPrice(dto.getPrice());
		entity.setDescription(dto.getDescription());
		entity.setQuantity(dto.getQuantity());
		entity.setManufacture_Company(dto.getManufacture_Company());

		return entity;
	}

	@Override
	public MedicineDto mapEntityToDto(Medicine entity) {
		MedicineDto dto = new MedicineDto();
		dto.setMedicine_Id(entity.getMedicine_Id());
		dto.setName(entity.getName());
		dto.setManufacture_Company(entity.getManufacture_Company());
		dto.setDescription(entity.getDescription());
		dto.setMedicine_Category(entity.getMedicine_Category());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());

		return dto;
	}

}
