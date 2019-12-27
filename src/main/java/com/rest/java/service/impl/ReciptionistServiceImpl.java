package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.ReciptionistDao;
import com.rest.java.dto.ReciptionistDto;
import com.rest.java.dto.LaboratoristDto;
import com.rest.java.entity.Reciptionist;
import com.rest.java.service.ReciptionistService;
@Service
public class ReciptionistServiceImpl implements ReciptionistService{

	@Autowired
	private ReciptionistDao reciptionistDao;
	
	@Override
	public ReciptionistDto addReciptionist(ReciptionistDto dto) {
		Reciptionist reciptionist=mapDtoToEntity(dto);
		reciptionist=reciptionistDao.addReciptionist(reciptionist);
		dto=mapEntityToDto(reciptionist);
		return dto;
	}

	@Override
	public ReciptionistDto updateReciptionist(ReciptionistDto dto) {
		Reciptionist reciptionist=mapDtoToEntity(dto);
		reciptionist=reciptionistDao.updateReciptionist(reciptionist);
		dto=mapEntityToDto(reciptionist);
		return dto;
	}

	@Override
	public ReciptionistDto getOneReciptionist(Integer recpId) {
		Reciptionist reciptionist=reciptionistDao.getOneReciptionist(recpId);
		ReciptionistDto dto=mapEntityToDto(reciptionist);
		return dto;
	}

	@Override
	public ReciptionistDto deleteReciptionist(Integer recpId) {
		Reciptionist reciptionist=reciptionistDao.deleteReciptionist(recpId);
		ReciptionistDto dto=mapEntityToDto(reciptionist);
		return dto;
	}
	
	
	@Override
	public List<ReciptionistDto> getAllReciptionist() {
		List<Reciptionist> reciptionist=reciptionistDao.getAllReciptionist();
		List<ReciptionistDto> dto=mapEntitiesToDtos(reciptionist.iterator());
		for(int i=0; i<reciptionist.size(); i++) {
			LaboratoristDto recip=new LaboratoristDto();
			BeanUtils.copyProperties(reciptionist.get(i), recip);
		}
		return dto;
	}
	private List<ReciptionistDto> mapEntitiesToDtos(Iterator<Reciptionist> reciptionistList) {
		List<ReciptionistDto> dto=null;
		if(reciptionistList!=null) {
			dto=new ArrayList<ReciptionistDto>();
			while(reciptionistList.hasNext()) {
				dto.add(mapEntityToDto(reciptionistList.next()));
			}
		}
		return dto;
	}

	@Override
	public Reciptionist mapDtoToEntity(ReciptionistDto dto) {
		Reciptionist entity=new Reciptionist();
		entity.setRecpId(dto.getRecpId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		return entity;
	}

	@Override
	public ReciptionistDto mapEntityToDto(Reciptionist entity) {
		ReciptionistDto dto=new ReciptionistDto();
		dto.setRecpId(entity.getRecpId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		return dto;
	}

	

	

}
