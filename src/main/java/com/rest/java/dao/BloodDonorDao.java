package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.BloodDonor;

public interface BloodDonorDao {

	public BloodDonor addBloodDonor(BloodDonor bloodDonor);
	
	public BloodDonor updateBloodDonor(BloodDonor bloodDonor);
	
	public BloodDonor getBloodDonorById(Integer donorId);
	
	public BloodDonor deleteBloodDonorById(Integer donorId);
	
	public List<BloodDonor> getAllBloodDonors();
}
