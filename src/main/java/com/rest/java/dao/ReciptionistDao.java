package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Reciptionist;

public interface ReciptionistDao {

	public Reciptionist addReciptionist(Reciptionist reciptionist);
	
	public Reciptionist updateReciptionist(Reciptionist reciptionist);
	
	public Reciptionist getOneReciptionist(Integer recpId);
	
	public Reciptionist deleteReciptionist(Integer recpId);
	
	public List<Reciptionist> getAllReciptionist();

	
}
