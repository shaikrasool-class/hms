package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.LaboratoristDto;
import com.rest.java.entity.Laboratorist;

public interface LaboratoristService extends BaseDao<LaboratoristDto, Laboratorist> {

	public LaboratoristDto addLaboratorist(LaboratoristDto dto);
	
	public LaboratoristDto updateLaboratorist(LaboratoristDto dto);
	
	public LaboratoristDto getOneLaboratorist(Integer labId);
	
	public LaboratoristDto deleteLaboratoristy(Integer labId);
	
	public List<LaboratoristDto> getAllLaboratorist();
}
