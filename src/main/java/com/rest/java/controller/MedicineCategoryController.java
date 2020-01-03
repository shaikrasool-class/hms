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

import com.rest.java.dto.MedicineCategoryDto;
import com.rest.java.service.MedicineCategoryService;

@RestController
@RequestMapping("medicineCategory")
public class MedicineCategoryController {

	@Autowired
	private MedicineCategoryService medicineCategoryService;
	
	@PostMapping("/createMedicine")
	public ResponseEntity<MedicineCategoryDto> createMedicineCategory(@RequestBody MedicineCategoryDto dto){
		MedicineCategoryDto medicine=medicineCategoryService.createMedicineCategory(dto);
		return new ResponseEntity<MedicineCategoryDto>(medicine, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateMedicine")
	public ResponseEntity<MedicineCategoryDto> updateMedicineCategory(@RequestBody MedicineCategoryDto dto){
		MedicineCategoryDto medicine=medicineCategoryService.updateMedicineCategory(dto);
		return new ResponseEntity<MedicineCategoryDto>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/medicine/{medId}")
	public ResponseEntity<MedicineCategoryDto> getOneMedicineCategory(@PathVariable Integer medId){
		MedicineCategoryDto medicine=medicineCategoryService.getMedicineCategory(medId);
		return new ResponseEntity<MedicineCategoryDto>(medicine, HttpStatus.OK);
	}
	
	@DeleteMapping("/medicine/{medId}")
	public ResponseEntity<MedicineCategoryDto> deleteMedicineCategory(@PathVariable Integer medId){
		MedicineCategoryDto medicine=medicineCategoryService.deleteMedicineCategory(medId);
		return new ResponseEntity<MedicineCategoryDto>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/allMedicineCategories")
	public ResponseEntity<List<MedicineCategoryDto>> getAllMedicineCategories(){
		List<MedicineCategoryDto> medicine=medicineCategoryService.getAllCategoryDtos();
		return new ResponseEntity<List<MedicineCategoryDto>>(medicine, HttpStatus.OK);
	}
}
