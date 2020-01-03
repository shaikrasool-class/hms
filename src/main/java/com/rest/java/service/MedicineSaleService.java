package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.MedicineSaleDto;
import com.rest.java.entity.MedicineSale;

public interface MedicineSaleService extends BaseDao<MedicineSaleDto, MedicineSale> {

	public MedicineSaleDto createMedicineSaleDto(MedicineSaleDto dto);
	
	public MedicineSaleDto updateMedicineSaleDto(MedicineSaleDto dto);
	
	public MedicineSaleDto getOneMedicineSaleDto(Integer med_Id);
	
	public MedicineSaleDto deleteMedicineSaleDto(Integer med_Id);
	
	public List<MedicineSaleDto> getAllMedicineDtos();
}
