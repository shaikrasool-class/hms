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

import com.rest.java.dto.LaboratoristDto;
import com.rest.java.service.LaboratoristService;

@RestController
@RequestMapping("laboratorist")
public class LaboratoristController {

	@Autowired
	private LaboratoristService laboratoristService;

	@PostMapping("/addLaboratorist")
	public ResponseEntity<LaboratoristDto> AddLaboratorist(@RequestBody LaboratoristDto dto){
		LaboratoristDto laboratorist=laboratoristService.addLaboratorist(dto);
		return new ResponseEntity<LaboratoristDto>(laboratorist, HttpStatus.OK);
	}

	@PutMapping("/updateLaboratorist")
	public ResponseEntity<LaboratoristDto> updateLaboratorist(@RequestBody LaboratoristDto dto){
		LaboratoristDto laboratorist=laboratoristService.updateLaboratorist(dto);
		return new ResponseEntity<LaboratoristDto>(laboratorist, HttpStatus.OK);
	}
	
	@GetMapping("/LaboratoristId/{labId}")
	public ResponseEntity<LaboratoristDto> getOneLaboratorist(@PathVariable Integer labId){
		LaboratoristDto laboratorist=laboratoristService.getOneLaboratorist(labId);
		return new ResponseEntity<LaboratoristDto>(laboratorist, HttpStatus.OK);
	}

	@DeleteMapping("/LaboratoristId/{labId}")
	public ResponseEntity<LaboratoristDto> deleteLaboratorist(@PathVariable Integer labId){
		LaboratoristDto laboratorist=laboratoristService.deleteLaboratoristy(labId);
		return new ResponseEntity<LaboratoristDto>(laboratorist, HttpStatus.OK);
	}

	@GetMapping("/allLaboratorist")
	public ResponseEntity<List<LaboratoristDto>> getAll(){
		List<LaboratoristDto> dto=laboratoristService.getAllLaboratorist();
		return new ResponseEntity<List<LaboratoristDto>>(dto, HttpStatus.OK);
		
	}
}
