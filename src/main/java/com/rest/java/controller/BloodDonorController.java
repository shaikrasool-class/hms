package com.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.BloodDonorDto;
import com.rest.java.service.BloodDonorService;

@RestController
@RequestMapping("/bloodDonor")
public class BloodDonorController {

	@Autowired
	private BloodDonorService bloodDonorService;
	
	@PostMapping("/createBloodDonor")
	public ResponseEntity<BloodDonorDto> addBloodDonor(@RequestBody BloodDonorDto dto){
		BloodDonorDto bloodDonor=bloodDonorService.addBloodDonor(dto);
		return new ResponseEntity<BloodDonorDto>(bloodDonor, HttpStatus.OK);
	}
	
	@PutMapping("/updateBloodDonor")
	public ResponseEntity<BloodDonorDto> updateBloodDonor(@RequestBody BloodDonorDto dto){
		BloodDonorDto bloodDonor=bloodDonorService.updateBloodDonor(dto);
		return new ResponseEntity<BloodDonorDto>(bloodDonor, HttpStatus.OK);
		
	}
	@GetMapping("/donor/{donorId}")
	public ResponseEntity<BloodDonorDto> getBloodDonorById(@PathVariable Integer donorId){
		BloodDonorDto bloodDonor=bloodDonorService.getBloodDonorById(donorId);
		return new ResponseEntity<BloodDonorDto>(bloodDonor, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDonor/{donorId}")
	public ResponseEntity<BloodDonorDto> deleteBloodDonor(@PathVariable Integer donorId){
		BloodDonorDto bloodDonor=bloodDonorService.deletBloodDonorById(donorId);
		return new ResponseEntity<BloodDonorDto>(bloodDonor, HttpStatus.OK);
	}
	@GetMapping("/getAllDonors")
	public ResponseEntity<List<BloodDonorDto>> getAll(){
		List<BloodDonorDto> dto=bloodDonorService.getALlDonors();
		return new ResponseEntity<List<BloodDonorDto>>(dto, HttpStatus.OK);
		
	}
	
}
