package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.BedAllotmentDto;
import com.rest.java.entity.BedAllotment;

public interface BedAllotmentService extends BaseDao<BedAllotmentDto, BedAllotment>{

	public BedAllotmentDto creaeBedAllotment(BedAllotmentDto bedAllotment);
	
	public BedAllotmentDto upBedAllotment(BedAllotmentDto bedAllotment);
	
	public BedAllotmentDto getBedAllotment(Integer bedId);
	
	public BedAllotmentDto deletBedAllotment(Integer bedId);
	
	public List<BedAllotmentDto> getAllBedAllotments();
}
