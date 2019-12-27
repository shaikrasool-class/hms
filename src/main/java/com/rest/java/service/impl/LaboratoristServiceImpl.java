package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.LaboratoristDao;
import com.rest.java.dto.LaboratoristDto;
import com.rest.java.entity.Laboratorist;
import com.rest.java.service.LaboratoristService;
@Service
public class LaboratoristServiceImpl implements LaboratoristService{

	@Autowired
	private LaboratoristDao laboratoristDao;
	
	
	@Override
	public LaboratoristDto addLaboratorist(LaboratoristDto dto) {
		Laboratorist laboratorist=mapDtoToEntity(dto);
		laboratorist = laboratoristDao.addLaboratorist(laboratorist);
		dto=mapEntityToDto(laboratorist);
		return dto;
	}

	@Override
	public LaboratoristDto updateLaboratorist(LaboratoristDto dto) {
		Laboratorist laboratorist=mapDtoToEntity(dto);
		laboratorist=laboratoristDao.updateLaboratorist(laboratorist);
		dto=mapEntityToDto(laboratorist);
		return dto;
	}

	@Override
	public LaboratoristDto getOneLaboratorist(Integer labId) {
		Laboratorist laboratorist=laboratoristDao.getOneLaboratorist(labId);
		LaboratoristDto dto=mapEntityToDto(laboratorist);
			return dto;
	}

	@Override
	public LaboratoristDto deleteLaboratoristy(Integer labId) {
		Laboratorist laboratorist=laboratoristDao.deleteLaboratorist(labId);
		LaboratoristDto dto=mapEntityToDto(laboratorist);
		return dto;
	}

	@Override
	public List<LaboratoristDto> getAllLaboratorist() {
		List<Laboratorist> laboratorist=laboratoristDao.getAllLaboratorist();
		List<LaboratoristDto> dto=mapEntitiesToDtos(laboratorist.iterator());
		for(int i=0; i<laboratorist.size(); i++) {
			LaboratoristDto lab=new LaboratoristDto();
			BeanUtils.copyProperties(laboratorist.get(i), lab);
		}
		return dto;
	}
	private List<LaboratoristDto> mapEntitiesToDtos(Iterator<Laboratorist> labList) {
		List<LaboratoristDto> dto=null;
		if(labList!=null) {
			dto=new ArrayList<LaboratoristDto>();
			while(labList.hasNext()) {
				dto.add(mapEntityToDto(labList.next()));
			}
		}
		return dto;
	}

	@Override
	public Laboratorist mapDtoToEntity(LaboratoristDto dto) {
		Laboratorist entity=new Laboratorist();
		entity.setLabId(dto.getLabId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		return entity;
	}

	@Override
	public LaboratoristDto mapEntityToDto(Laboratorist entity) {
		LaboratoristDto dto=new LaboratoristDto();
		dto.setLabId(entity.getLabId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		return dto;
	}

}
