package com.rest.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.java.dao.FileRepository;
import com.rest.java.dto.DoctorDto;
import com.rest.java.entity.Doctor;
import com.rest.java.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {

	@Autowired
	private DoctorService service;

	@Autowired
	private	FileRepository fileRepository;

	@PostMapping("/saveDoctor")
	public ResponseEntity<DoctorDto> saveDoctor(@Valid @RequestBody DoctorDto dto) {
		DoctorDto doctor = service.addDoctor(dto);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}

	@GetMapping("/allDoctors")
	public ResponseEntity<List<DoctorDto>> getAllDoctors() {
		List<DoctorDto> doctors = service.getAllDoctors();
		return new ResponseEntity<List<DoctorDto>>(doctors, HttpStatus.OK);
	}

	@PutMapping("/updateDoctor")
	public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto dto) {
		DoctorDto doctor = service.updateDoctor(dto);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}

	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<DoctorDto> deleteDoctor(@PathVariable int id) {
		DoctorDto doctor = service.deleteDoctor(id);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}

	@GetMapping("/doctorId/{id}")
	public ResponseEntity<DoctorDto> getOneDoctor(@PathVariable int id) {
		DoctorDto doctor = service.getOneDoctorById(id);
		return new ResponseEntity<DoctorDto>(doctor, HttpStatus.OK);
	}
	
	
	@PostMapping("/api/file/upload")
    public ResponseEntity<DoctorDto> uploadMultipartFile(@RequestParam("file") MultipartFile file) {
      try {
    	Doctor filemode = new Doctor(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    	
    	fileRepository.save(filemode);
       //return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
    	return new ResponseEntity<DoctorDto>(HttpStatus.OK);
    } catch (  Exception e) {
     //return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
    	return new ResponseEntity<DoctorDto>(HttpStatus.BAD_REQUEST);
    }    
    }
    

}
