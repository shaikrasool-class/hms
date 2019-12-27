package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Laboratorist;

public interface LaboratoristDao {

	public Laboratorist addLaboratorist(Laboratorist lab);
	
	public Laboratorist updateLaboratorist(Laboratorist lab);
	
	public Laboratorist getOneLaboratorist(Integer labId);
	
	public Laboratorist deleteLaboratorist(Integer labId);
	
	public List<Laboratorist> getAllLaboratorist();
	
}
