package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Bed;

public interface BedDao {

	public Bed createBed(Bed bed);
	
	public Bed updateBed(Bed bed);
	
	public Bed GetOneBedById(Integer bed_Id);
	
	public Bed deleteBed(Integer bed_Id);
	
	public List<Bed>getAllBeds();
}
