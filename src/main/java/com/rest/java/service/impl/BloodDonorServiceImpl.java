package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.BloodDonorDao;
import com.rest.java.dto.BloodDonorDto;
import com.rest.java.entity.BloodDonor;
import com.rest.java.service.BloodDonorService;

@Service
public class BloodDonorServiceImpl implements BloodDonorService{
	
	@Autowired
	private BloodDonorDao bloodDonorDao;

	@Override
	public BloodDonorDto addBloodDonor(BloodDonorDto bloodDonor) {
		BloodDonor donor=mapDtoToEntity(bloodDonor);
		donor=bloodDonorDao.addBloodDonor(donor);
		BloodDonorDto dto=mapEntityToDto(donor);
		return dto; 
	}

	@Override
	public BloodDonorDto updateBloodDonor(BloodDonorDto bloodDonor) {
		BloodDonor donor=mapDtoToEntity(bloodDonor);
		donor=bloodDonorDao.updateBloodDonor(donor);
		BloodDonorDto dto=mapEntityToDto(donor);
		return dto;
	}

	@Override
	public BloodDonorDto getBloodDonorById(Integer donorId) {
		BloodDonor donor=bloodDonorDao.getBloodDonorById(donorId);
		BloodDonorDto dto=mapEntityToDto(donor);
		return dto;
	}

	@Override
	public BloodDonorDto deletBloodDonorById(Integer donorId) {
		BloodDonor donor=bloodDonorDao.deleteBloodDonorById(donorId);
		BloodDonorDto dto=mapEntityToDto(donor);
		return dto;
	}

	@Override
	public List<BloodDonorDto> getALlDonors() {
		List<BloodDonor> donors=bloodDonorDao.getAllBloodDonors();
		List<BloodDonorDto> dtos=mapEntitiesToDtos(donors.iterator());
		for(int i=0; i<donors.size(); i++) {
			BloodDonorDto dto=new BloodDonorDto();
			BeanUtils.copyProperties(donors.get(i), dto);
		}
		return dtos;
	}


	private List<BloodDonorDto> mapEntitiesToDtos(Iterator<BloodDonor> donorsList) {
			List<BloodDonorDto> dtos=null;
			if(donorsList !=null) {
				dtos=new ArrayList<BloodDonorDto>();
				while(donorsList.hasNext()) {
					
				}
			}
			
		return null;
	}

	@Override
	public BloodDonor mapDtoToEntity(BloodDonorDto dto) {
		BloodDonor entity=new BloodDonor();
		entity.setDonorId(dto.getDonorId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setGender(dto.getGender());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setGender(dto.getGender());
		entity.setAge(dto.getAge());
		entity.setBloodgroup(dto.getBloodgroup());
		entity.setDate(dto.getDate());
		return entity;
	}

	@Override
	public BloodDonorDto mapEntityToDto(BloodDonor entity) {
		BloodDonorDto dto=new BloodDonorDto();
		dto.setDonorId(entity.getDonorId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setAddress(entity.getGender());
		dto.setPhone(entity.getPhone());
		dto.setGender(entity.getGender());
		dto.setAge(entity.getAge());
		dto.setBloodgroup(entity.getBloodgroup());
		dto.setDate(entity.getDate());
		return dto;
	}

	
}
