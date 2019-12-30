package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.BedDto;
import com.rest.java.entity.Bed;

public interface BedService extends BaseDao<BedDto, Bed>{

	public BedDto createBed(BedDto dto);
	
	public BedDto updateBed(BedDto dto);
	
	public BedDto getBedById(Integer bed_Id);
	
	public BedDto deleteBed(Integer bed_Id);
	
	public List<BedDto> getAllBeds();
}
