package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.BloodDonorDto;
import com.rest.java.entity.BloodDonor;

public interface BloodDonorService extends BaseDao<BloodDonorDto, BloodDonor> {
	
	public BloodDonorDto addBloodDonor(BloodDonorDto bloodDonor);
	
	public BloodDonorDto updateBloodDonor(BloodDonorDto bloodDonor);
	
	public BloodDonorDto getBloodDonorById(Integer donorId);
	
	public BloodDonorDto deletBloodDonorById(Integer donorId);
	
	public List<BloodDonorDto> getALlDonors();

}
