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

import com.rest.java.dto.AccountantDto;
import com.rest.java.service.AccountantService;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

	@Autowired
	private AccountantService AccountantService;

	@PostMapping("/addAccountant")
	public ResponseEntity<AccountantDto> AddAccountant(@RequestBody AccountantDto dto){
		AccountantDto Accountant=AccountantService.addAccountant(dto);
		return new ResponseEntity<AccountantDto>(Accountant, HttpStatus.OK);
	}

	@PutMapping("/updateAccountant")
	public ResponseEntity<AccountantDto> updateAccountant(@RequestBody AccountantDto dto){
		AccountantDto Accountant=AccountantService.updateAccountant(dto);
		return new ResponseEntity<AccountantDto>(Accountant, HttpStatus.OK);
	}
	
	@GetMapping("/accountantId/{acId}")
	public ResponseEntity<AccountantDto> getOneAccountant(@PathVariable Integer acId){
		AccountantDto Accountant=AccountantService.getOneAccountant(acId);
		return new ResponseEntity<AccountantDto>(Accountant, HttpStatus.OK);
	}

	@DeleteMapping("/accountantId/{acId}")
	public ResponseEntity<AccountantDto> deleteAccountant(@PathVariable Integer acId){
		AccountantDto Accountant=AccountantService.deleteAccountant(acId);
		return new ResponseEntity<AccountantDto>(Accountant, HttpStatus.OK);
	}

	@GetMapping("/allAccountant")
	public ResponseEntity<List<AccountantDto>> getAll(){
		List<AccountantDto> dto=AccountantService.getAllAccountant();
		return new ResponseEntity<List<AccountantDto>>(dto, HttpStatus.OK);
		
	}
}
