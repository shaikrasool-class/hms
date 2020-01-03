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

import com.rest.java.dto.MedicineSaleDto;
import com.rest.java.service.MedicineSaleService;

@RestController
@RequestMapping("/medicineSale")
public class MedicineSaleController {
	
	@Autowired
	private MedicineSaleService medicineSaleService;
	
	
	@PostMapping("/createSale")
	public ResponseEntity<MedicineSaleDto> addMedicineSale(@RequestBody MedicineSaleDto dto){
		MedicineSaleDto medicine=medicineSaleService.createMedicineSaleDto(dto);
		return new ResponseEntity<MedicineSaleDto>(medicine, HttpStatus.OK);
	}
	@PutMapping("/updateSale")
	public ResponseEntity<MedicineSaleDto> updateMedicineSale(@RequestBody MedicineSaleDto dto){
		MedicineSaleDto medicine=medicineSaleService.updateMedicineSaleDto(dto);
		return new ResponseEntity<MedicineSaleDto>(medicine, HttpStatus.OK);
	}
	
	@GetMapping("/sale/{med_Id}")
	public ResponseEntity<MedicineSaleDto> getmedicineSale(@PathVariable Integer med_Id){
		MedicineSaleDto medicine=medicineSaleService.getOneMedicineSaleDto(med_Id);
		return new ResponseEntity<MedicineSaleDto>(medicine, HttpStatus.OK);
	}
	@DeleteMapping("/sale/{med_Id}")
	public ResponseEntity<MedicineSaleDto> deleteMedicineSale(@PathVariable Integer med_Id){
		MedicineSaleDto medicine=medicineSaleService.deleteMedicineSaleDto(med_Id);
		return new ResponseEntity<MedicineSaleDto>(medicine, HttpStatus.OK);
	}
	@GetMapping("/allSales")
	public ResponseEntity<List<MedicineSaleDto>> getAllSales(){
		List<MedicineSaleDto> medicines=medicineSaleService.getAllMedicineDtos();
		return new ResponseEntity<List<MedicineSaleDto>>(medicines, HttpStatus.OK);
	}
}
