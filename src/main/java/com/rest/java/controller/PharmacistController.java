package com.rest.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.java.dto.PharmacistDto;
import com.rest.java.service.PharmacistService;

@RestController
@RequestMapping("/pharmacist")

public class PharmacistController {

	@Autowired
	private PharmacistService pharmacistService;
	
	@PostMapping("/savePharmacist")
	public ResponseEntity<PharmacistDto> addPharmacist(@RequestBody PharmacistDto dto){
		PharmacistDto pharmacistDto=pharmacistService.addPharmacist(dto);
		return new ResponseEntity<PharmacistDto>(pharmacistDto, HttpStatus.OK);
		
	}
	
	@GetMapping("/pharmacistId/{phId}")
	public ResponseEntity<PharmacistDto> getOnePharmacistById(@PathVariable Integer phId){
		PharmacistDto pharmacistDto=pharmacistService.getOnePharmacist(phId);
		return new ResponseEntity<PharmacistDto>(pharmacistDto, HttpStatus.OK);
	}
	@PutMapping("/updatePharmacist")
	public ResponseEntity<PharmacistDto> updatePharmacist(@RequestBody PharmacistDto dto){
		PharmacistDto pharmacistDto=pharmacistService.updatePharmacist(dto);
		return new ResponseEntity<PharmacistDto>(pharmacistDto, HttpStatus.OK);
	}
	@GetMapping("/allPharmacist")
	public ResponseEntity<List<PharmacistDto>> getAllPharmacists(){
		List<PharmacistDto> dtos=pharmacistService.getAllPharmacist();
		return new ResponseEntity<List<PharmacistDto>>(dtos, HttpStatus.OK);
	}
	@DeleteMapping("/pharmacistId/{phId}")
	public ResponseEntity<PharmacistDto> deletePharmacist(@PathVariable Integer phId){
		PharmacistDto dto=pharmacistService.deletePharmacist(phId);
		return new ResponseEntity<PharmacistDto>(dto, HttpStatus.OK);
	}
}
