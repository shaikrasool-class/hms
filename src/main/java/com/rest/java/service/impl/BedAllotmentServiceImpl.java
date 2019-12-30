package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.BedAllotmentDao;
import com.rest.java.dto.BedAllotmentDto;
import com.rest.java.entity.BedAllotment;
import com.rest.java.service.BedAllotmentService;

@Service
public class BedAllotmentServiceImpl implements BedAllotmentService {

	@Autowired
	private BedAllotmentDao bedAllotmentDao;
	
	
	@Override
	public BedAllotmentDto creaeBedAllotment(BedAllotmentDto bedAllotment) {
		BedAllotment bed = mapDtoToEntity(bedAllotment);
		bed = bedAllotmentDao.createBedAllotment(bed);
		return mapEntityToDto(bed);
	}

	@Override
	public BedAllotmentDto upBedAllotment(BedAllotmentDto bedAllotment) {
		BedAllotment bed = mapDtoToEntity(bedAllotment);
		bed = bedAllotmentDao.upBedAllotment(bed);
		return mapEntityToDto(bed);
	}

	@Override
	public BedAllotmentDto getBedAllotment(Integer bedId) {
		BedAllotment bed = bedAllotmentDao.getBedAllotment(bedId);
		BedAllotmentDto dto = mapEntityToDto(bed);
		return dto;
	}

	@Override
	public BedAllotmentDto deletBedAllotment(Integer bedId) {
		BedAllotment bed = bedAllotmentDao.deBedAllotment(bedId);
		BedAllotmentDto dto = mapEntityToDto(bed);
		return dto;
	}

	@Override
	public List<BedAllotmentDto> getAllBedAllotments() {
		List<BedAllotment> bedAllotments = bedAllotmentDao.getAllBedAllotments();
		List<BedAllotmentDto> dtos = mapEntitiesToDto(bedAllotments.iterator());
		for (int i = 0; i < bedAllotments.size(); i++) {
			BedAllotmentDto dto = new BedAllotmentDto();
			BeanUtils.copyProperties(bedAllotments.get(i), dto);
		}
		return dtos;
	}

	private List<BedAllotmentDto> mapEntitiesToDto(Iterator<BedAllotment> bedList) {
		List<BedAllotmentDto> bedDtos = null;
		if (bedList != null) {
			bedDtos = new ArrayList<BedAllotmentDto>();
			while (bedList.hasNext()) {
				bedDtos.add(mapEntityToDto(bedList.next()));
			}
		}
		return bedDtos;
	}

	@Override
	public BedAllotment mapDtoToEntity(BedAllotmentDto dto) {
		BedAllotment entity = new BedAllotment();
		entity.setBedId(dto.getBedId());
		entity.setBedNumber(dto.getBedNumber());
		entity.setAllotmentDate(dto.getAllotmentDate());
		entity.setDischargeDate(dto.getDischargeDate());
		return entity;
	}

	@Override
	public BedAllotmentDto mapEntityToDto(BedAllotment entity) {
		BedAllotmentDto dto = new BedAllotmentDto();
		dto.setBedId(entity.getBedId());
		dto.setBedNumber(entity.getBedNumber());
		dto.setAllotmentDate(entity.getAllotmentDate());
		dto.setDischargeDate(dto.getDischargeDate());
		return dto;
	}

	
}
