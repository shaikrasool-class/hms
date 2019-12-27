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

import com.rest.java.dto.ReciptionistDto;
import com.rest.java.service.ReciptionistService;

@RestController
@RequestMapping("/reciptionist")
public class ReciptionistController {

	@Autowired
	private ReciptionistService reciptionistService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addReciptionist")
	public ResponseEntity<ReciptionistDto> AddReciptionist(@RequestBody ReciptionistDto dto){
		ReciptionistDto reciptionist=reciptionistService.addReciptionist(dto);
		return new ResponseEntity<ReciptionistDto>(reciptionist, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateReciptionist")
	public ResponseEntity<ReciptionistDto> updateReciptionist(@RequestBody ReciptionistDto dto){
		ReciptionistDto reciptionist=reciptionistService.updateReciptionist(dto);
		return new ResponseEntity<ReciptionistDto>(reciptionist, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/reciptionistId/{acId}")
	public ResponseEntity<ReciptionistDto> getOneReciptionist(@PathVariable Integer recpId){
		ReciptionistDto reciptionist=reciptionistService.getOneReciptionist(recpId);
		return new ResponseEntity<ReciptionistDto>(reciptionist, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/reciptionistId/{acId}")
	public ResponseEntity<ReciptionistDto> deleteReciptionist(@PathVariable Integer recpId){
		ReciptionistDto reciptionist=reciptionistService.deleteReciptionist(recpId);
		return new ResponseEntity<ReciptionistDto>(reciptionist, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/allReciptionist")
	public ResponseEntity<List<ReciptionistDto>> getAll(){
		List<ReciptionistDto> dto=reciptionistService.getAllReciptionist();
		return new ResponseEntity<List<ReciptionistDto>>(dto, HttpStatus.OK);
		
	}
}
