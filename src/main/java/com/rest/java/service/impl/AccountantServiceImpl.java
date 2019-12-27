package com.rest.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.java.dao.AccountantDao;
import com.rest.java.dto.AccountantDto;
import com.rest.java.dto.LaboratoristDto;
import com.rest.java.entity.Accountant;
import com.rest.java.service.AccountantService;
@Service
public class AccountantServiceImpl implements AccountantService{

	@Autowired
	private AccountantDao accountantDao;
	
	@Override
	public AccountantDto addAccountant(AccountantDto dto) {
		Accountant accountant=mapDtoToEntity(dto);
		accountant=accountantDao.addAccountant(accountant);
		dto=mapEntityToDto(accountant);
		return dto;
	}

	@Override
	public AccountantDto updateAccountant(AccountantDto dto) {
		Accountant accountant=mapDtoToEntity(dto);
		accountant=accountantDao.updateAccountant(accountant);
		dto=mapEntityToDto(accountant);
		return dto;
	}

	@Override
	public AccountantDto getOneAccountant(Integer acId) {
		Accountant accountant=accountantDao.getOneAccountant(acId);
		AccountantDto dto=mapEntityToDto(accountant);
		return dto;
	}

	@Override
	public AccountantDto deleteAccountant(Integer acId) {
		Accountant accountant=accountantDao.deleteAccountant(acId);
		AccountantDto dto=mapEntityToDto(accountant);
		return dto;
	}
	
	
	@Override
	public List<AccountantDto> getAllAccountant() {
		List<Accountant> accountant=accountantDao.getAllAccountant();
		List<AccountantDto> dto=mapEntitiesToDtos(accountant.iterator());
		for(int i=0; i<accountant.size(); i++) {
			LaboratoristDto lab=new LaboratoristDto();
			BeanUtils.copyProperties(accountant.get(i), lab);
		}
		return dto;
	}
	private List<AccountantDto> mapEntitiesToDtos(Iterator<Accountant> accountantList) {
		List<AccountantDto> dto=null;
		if(accountantList!=null) {
			dto=new ArrayList<AccountantDto>();
			while(accountantList.hasNext()) {
				dto.add(mapEntityToDto(accountantList.next()));
			}
		}
		return dto;
	}

	@Override
	public Accountant mapDtoToEntity(AccountantDto dto) {
		Accountant entity=new Accountant();
		entity.setAcId(dto.getAcId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setAddress(dto.getAddress());
		return entity;
	}

	@Override
	public AccountantDto mapEntityToDto(Accountant entity) {
		AccountantDto dto=new AccountantDto();
		dto.setAcId(entity.getAcId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		return dto;
	}

	

	

}
