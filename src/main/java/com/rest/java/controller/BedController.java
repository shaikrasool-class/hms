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

import com.rest.java.dto.BedDto;
import com.rest.java.service.BedService;

@RestController
@RequestMapping("/bed")
public class BedController {

	
	@Autowired
	private BedService bedService;
	
	@PostMapping("/createBed")
	public ResponseEntity<BedDto> createBed(@RequestBody BedDto dto){
		BedDto bed=bedService.createBed(dto);
		return new ResponseEntity<BedDto>(bed, HttpStatus.OK);
	}
	
	@PutMapping("/updateBed")
	public ResponseEntity<BedDto> updateBed(@RequestBody BedDto dto){
		BedDto bed=bedService.updateBed(dto);
		return new ResponseEntity<BedDto>(bed, HttpStatus.OK);
	}
	
	@GetMapping("/bedId/{bed_Id}")
	public ResponseEntity<BedDto>getOneBedById(@PathVariable Integer bed_Id){
		BedDto bed=bedService.getBedById(bed_Id);
		return new ResponseEntity<BedDto>(bed, HttpStatus.OK);
	}
	@GetMapping("/allBeds")
	public ResponseEntity<List<BedDto>> getAllbeds(){
	List<BedDto> beds=bedService.getAllBeds();
	return new ResponseEntity<List<BedDto>>(beds, HttpStatus.OK);
	}
	@DeleteMapping("/deleteBed/{bed_Id}")
	public ResponseEntity<BedDto> deleteBedById(@PathVariable Integer bed_Id){
		BedDto bed=bedService.deleteBed(bed_Id);
		return new ResponseEntity<BedDto>(bed, HttpStatus.OK);
	}
}