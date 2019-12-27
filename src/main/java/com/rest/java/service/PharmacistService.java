package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.PharmacistDto;
import com.rest.java.entity.Pharmacist;

public interface PharmacistService extends BaseDao<PharmacistDto, Pharmacist> {

	public PharmacistDto addPharmacist(PharmacistDto pharmacist);
	
	public PharmacistDto updatePharmacist(PharmacistDto pharmacist);
	
	public PharmacistDto getOnePharmacist(Integer phId);
	
	public PharmacistDto deletePharmacist(Integer phId);
	
	public List<PharmacistDto> getAllPharmacist();
	
}
