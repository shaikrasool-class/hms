package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.ReciptionistDto;
import com.rest.java.entity.Reciptionist;

public interface ReciptionistService extends BaseDao<ReciptionistDto, Reciptionist> {

	public ReciptionistDto addReciptionist(ReciptionistDto dto);
	
	public ReciptionistDto updateReciptionist(ReciptionistDto dto);
	
	public ReciptionistDto getOneReciptionist(Integer acId);
	
	public ReciptionistDto deleteReciptionist(Integer acId);
	
	public List<ReciptionistDto> getAllReciptionist();
}
