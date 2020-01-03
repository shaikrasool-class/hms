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

import com.rest.java.dto.MedicineDto;
import com.rest.java.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@PostMapping("/createMedicine")
	public ResponseEntity<MedicineDto> createMedinice(@RequestBody MedicineDto dto){
		MedicineDto medicine=medicineService.createMedicine(dto);
		return new ResponseEntity<MedicineDto>(medicine, HttpStatus.OK);
	}
	
	
	@PutMapping("/updateMedicine")
	public ResponseEntity<MedicineDto> updateMedicine(@RequestBody MedicineDto dto){
		MedicineDto medicine=medicineService.updateMedicine(dto);
		return new  ResponseEntity<MedicineDto>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/medicine/{medicine_Id}")
	public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Integer medicine_Id){
		MedicineDto medicine=medicineService.getOneMedicineById(medicine_Id);
		return new ResponseEntity<MedicineDto>(medicine, HttpStatus.OK);
	}
	
	@DeleteMapping("/medicine/{medicine_Id}")
	public ResponseEntity<MedicineDto> deleteMedicineById(@PathVariable Integer medicine_Id){
		MedicineDto medicine=medicineService.deleteMedicine(medicine_Id);
		return new ResponseEntity<MedicineDto>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/allMedicines")
	public ResponseEntity<List<MedicineDto>> getAllMedicines(){
		List<MedicineDto> medicine=medicineService.getAllMedicines();
		return new ResponseEntity<List<MedicineDto>>(medicine, HttpStatus.OK);
	}
}
