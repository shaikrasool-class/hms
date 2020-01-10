package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rest.java.dao.MedicineSaleDao;
import com.rest.java.dto.MedicineDto;
import com.rest.java.dto.MedicineSaleDto;
import com.rest.java.entity.Medicine;
import com.rest.java.entity.MedicineSale;
import com.rest.java.service.MedicineSaleService;
@Service
public class MedicineSaleServiceImpl implements MedicineSaleService {

	private MedicineSaleDao medicineSaleDao;

	@Override
	public MedicineSaleDto createMedicineSaleDto(MedicineSaleDto dto) {

		MedicineSale medicine = mapDtoToEntity(dto);
		medicine = medicineSaleDao.createMedicineSale(medicine);
		return mapEntityToDto(medicine);

	}

	@Override
	public MedicineSaleDto updateMedicineSaleDto(MedicineSaleDto dto) {
		MedicineSale medicine=mapDtoToEntity(dto);
		medicine=medicineSaleDao.updMedicineSale(medicine);
		return mapEntityToDto(medicine);
	}

	@Override
	public MedicineSaleDto getOneMedicineSaleDto(Integer med_Id) {
		MedicineSale medicine=medicineSaleDao.getMedicineSale(med_Id);
		MedicineSaleDto dto=mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public MedicineSaleDto deleteMedicineSaleDto(Integer med_Id) {
		MedicineSale medicine=medicineSaleDao.deleteMedicineSale(med_Id);
		MedicineSaleDto dto=mapEntityToDto(medicine);
		return dto;
	}

	@Override
	public List<MedicineSaleDto> getAllMedicineDtos() {
		List<MedicineSale> medicine=medicineSaleDao.getAllMedicineSalse();
		List<MedicineSaleDto> medicineDtos=mapEntitiesToDtos(medicine.iterator());
		for(int i=0; i<medicine.size(); i++) {
			MedicineSaleDto dto=new MedicineSaleDto();
			BeanUtils.copyProperties(medicine.get(i), dto);
		}
		return medicineDtos;
	}

	private List<MedicineSaleDto> mapEntitiesToDtos(Iterator<MedicineSale> medicineSaleList) {
		List<MedicineSaleDto> medicineDtos=null;
		if(medicineSaleList!=null) {
			medicineDtos=new ArrayList<MedicineSaleDto>();
			while(medicineSaleList.hasNext()) {
				medicineDtos.add(mapEntityToDto(medicineSaleList.next()));
			}
		}
		return medicineDtos;
	}

	@Override
	public MedicineSale mapDtoToEntity(MedicineSaleDto dto) {

		MedicineSale entity = new MedicineSale();
		entity.setMed_Id(dto.getMed_Id());
		entity.setPatientName(dto.getPatientName());
		entity.setPrice(dto.getPrice());

		List<MedicineDto> medicineDtos = dto.getMedicines();

		if (medicineDtos != null && medicineDtos.size() > 0) {
			List<Medicine> medicine = new ArrayList<Medicine>();
			for (MedicineDto medicineDto : medicineDtos) {
				medicine.add(mapDtoToEntity(medicineDto));
			}
			entity.setMedicines(medicine);
		}
		return entity;
	}

	@Override
	public MedicineSaleDto mapEntityToDto(MedicineSale entity) {
		MedicineSaleDto dto = new MedicineSaleDto();
		dto.setMed_Id(entity.getMed_Id());
		dto.setPatientName(entity.getPatientName());
		dto.setPrice(entity.getPrice());
 
		List<Medicine> medicine = entity.getMedicines();

		if (medicine != null && medicine.size() > 0) {
			List<MedicineDto> medicineDto = new ArrayList<MedicineDto>();

			for (Medicine p : medicine) {
				medicineDto.add(mapEntityToDto(p));
			}
			dto.setMedicines(medicineDto);
		}

		return dto;
	}

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
