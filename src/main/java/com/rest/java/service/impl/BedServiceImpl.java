package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.BedDao;
import com.rest.java.dto.BedDto;
import com.rest.java.entity.Bed;
import com.rest.java.service.BedService;

@Service
public class BedServiceImpl implements BedService {
	@Autowired
	private BedDao bedDao;

	@Override
	public BedDto createBed(BedDto dto) {
		Bed bed = mapDtoToEntity(dto);
		bed = bedDao.createBed(bed);
		return mapEntityToDto(bed);
	}

	@Override
	public BedDto updateBed(BedDto dto) {
		Bed bed = mapDtoToEntity(dto);
		bed = bedDao.updateBed(bed);
		return mapEntityToDto(bed);
	}

	@Override
	public BedDto getBedById(Integer bed_Id) {
		Bed bed = bedDao.GetOneBedById(bed_Id);
		BedDto dto = mapEntityToDto(bed);
		return dto;
	}

	@Override
	public BedDto deleteBed(Integer bed_Id) {
		Bed bed = bedDao.deleteBed(bed_Id);
		BedDto dto = mapEntityToDto(bed);
		return dto;
	}

	@Override
	public List<BedDto> getAllBeds() {
		List<Bed> beds = bedDao.getAllBeds();
		List<BedDto> bedDtos = mapEntitiesToDtos(beds.iterator());
		for (int i = 0; i < beds.size(); i++) {
			BedDto dto = new BedDto();
			BeanUtils.copyProperties(beds.get(i), dto);
		}

		return bedDtos;
	}

	private List<BedDto> mapEntitiesToDtos(Iterator<Bed> bedList) {
		List<BedDto> dtos = null;
		if (bedList != null) {
			dtos = new ArrayList<BedDto>();
			while (bedList.hasNext()) {
				dtos.add(mapEntityToDto(bedList.next()));
			}
		}
		return dtos;
	}

	@Override
	public Bed mapDtoToEntity(BedDto dto) {

		Bed entity = new Bed();
		entity.setBed_Id(dto.getBed_Id());
		entity.setBedNumber(dto.getBedNumber());
		entity.setBedType(dto.getBedType());
		entity.setWard(dto.getWard());
		entity.setDescription(dto.getDescription());
		return entity;
	}

	@Override
	public BedDto mapEntityToDto(Bed entity) {

		BedDto dto = new BedDto();
		dto.setBed_Id(entity.getBed_Id());
		dto.setBedNumber(entity.getBedNumber());
		dto.setBedType(entity.getBedType());
		dto.setWard(entity.getWard());
		dto.setDescription(entity.getDescription());
		return dto;
	}

}
