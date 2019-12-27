package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.PharmacistDao;
import com.rest.java.dto.PharmacistDto;
import com.rest.java.entity.Pharmacist;
import com.rest.java.service.PharmacistService;

@Service
public class PharmacistServiceImpl implements PharmacistService{
	
	@Autowired
	private PharmacistDao pharmacistDao;

	@Override
	public PharmacistDto addPharmacist(PharmacistDto pharmacist) {
			Pharmacist pharma=mapDtoToEntity(pharmacist);
			pharma=pharmacistDao.addPharmacist(pharma);
			pharmacist=mapEntityToDto(pharma);
		return pharmacist;
	}

	@Override
	public PharmacistDto updatePharmacist(PharmacistDto pharmacist) {
		Pharmacist pharma=mapDtoToEntity(pharmacist);
		pharma=pharmacistDao.updatePharmacist(pharma);
		pharmacist=mapEntityToDto(pharma);
		return pharmacist;
	}

	@Override
	public PharmacistDto getOnePharmacist(Integer phId) {
		Pharmacist pharmacist=pharmacistDao.getOnePharmacist(phId);
		PharmacistDto dto=mapEntityToDto(pharmacist);
		return dto;
	}

	@Override
	public PharmacistDto deletePharmacist(Integer phId) {
		Pharmacist pharmacist=pharmacistDao.deletePharmacist(phId);
		PharmacistDto dto=mapEntityToDto(pharmacist);
		return dto;
	}

	@Override
	public List<PharmacistDto> getAllPharmacist() {
		List<Pharmacist> pharmacists=pharmacistDao.getPharmacists();
		List<PharmacistDto> dtos=mapEntitiesToDto(pharmacists.iterator());
		for(int i=0; i<dtos.size();i++) {
			PharmacistDto pharmacist=new PharmacistDto();
			BeanUtils.copyProperties(dtos.get(i), pharmacist);
		}
		return dtos;
	}

	private List<PharmacistDto> mapEntitiesToDto(Iterator<Pharmacist> pharmacists) {
		List<PharmacistDto> pharmacistDtos =null;
		if(pharmacists!=null) {
			pharmacistDtos=new ArrayList<PharmacistDto>();
			while(pharmacists.hasNext()) {
				pharmacistDtos.add(mapEntityToDto(pharmacists.next()));
			}
		}
		return pharmacistDtos;
	}

	@Override
	public Pharmacist mapDtoToEntity(PharmacistDto dto) {
		Pharmacist entity=new Pharmacist();
		entity.setPhId(dto.getPhId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		return entity;
	}

	@Override
	public PharmacistDto mapEntityToDto(Pharmacist entity) {
		PharmacistDto dto=new PharmacistDto();
		dto.setPhId(entity.getPhId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		return dto;
	}

}
