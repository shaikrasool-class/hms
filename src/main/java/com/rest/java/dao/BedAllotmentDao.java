package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.BedAllotment;

public interface BedAllotmentDao {

	public BedAllotment createBedAllotment(BedAllotment bedAllotment);
	
	public BedAllotment upBedAllotment(BedAllotment bedAllotment);
	
	public BedAllotment getBedAllotment(Integer bedId);
	
	public BedAllotment deBedAllotment(Integer bedId);
	
	public List<BedAllotment> getAllBedAllotments();
}
