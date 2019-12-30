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

import com.rest.java.dto.BedAllotmentDto;
import com.rest.java.service.BedAllotmentService;

@RestController
@RequestMapping("/bedAllotment")
public class BedAllotmentController {

	@Autowired
	private BedAllotmentService bedAllotmentService;

	@PostMapping("/createBed")
	public ResponseEntity<BedAllotmentDto> saveBedAllotment(@RequestBody BedAllotmentDto bedAllotment) {
		BedAllotmentDto bed = bedAllotmentService.creaeBedAllotment(bedAllotment);
		return new ResponseEntity<BedAllotmentDto>(bed, HttpStatus.OK);
	}
	
	@PutMapping("/updateBed")
	public ResponseEntity<BedAllotmentDto> updateBedAllotment(@RequestBody BedAllotmentDto bedAllotment){
		BedAllotmentDto bed=bedAllotmentService.upBedAllotment(bedAllotment);
		return new ResponseEntity<BedAllotmentDto>(bed, HttpStatus.OK);
	}
	@GetMapping("/bed/{bedId}")
	public ResponseEntity<BedAllotmentDto> getOneBedAllotmen(@PathVariable Integer bedId){
		BedAllotmentDto bed=bedAllotmentService.getBedAllotment(bedId);
		return new ResponseEntity<BedAllotmentDto>(bed, HttpStatus.OK);
	}
	
	@DeleteMapping("/bed/{bedId}")
	public ResponseEntity<BedAllotmentDto> deleteBedAllotment(@PathVariable Integer bedId){
		BedAllotmentDto bed= bedAllotmentService.deletBedAllotment(bedId);
		return new ResponseEntity<BedAllotmentDto>(bed, HttpStatus.OK);
	}
	@GetMapping("/allBedAllotments")
	public ResponseEntity<List<BedAllotmentDto>> getAllBedAllotments(){
		List<BedAllotmentDto> beds=bedAllotmentService.getAllBedAllotments();
		return new ResponseEntity<List<BedAllotmentDto>>(beds, HttpStatus.OK);
	}
}
