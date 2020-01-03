package com.rest.java.service;

import java.util.List;

import com.rest.java.dto.AccountantDto;
import com.rest.java.entity.Accountant;

public interface AccountantService extends BaseDao<AccountantDto, Accountant> {

	public AccountantDto addAccountant(AccountantDto dto);
	
	public AccountantDto updateAccountant(AccountantDto dto);
	
	public AccountantDto getOneAccountant(Integer acId);
	
	public AccountantDto deleteAccountant(Integer acId);
	
	public List<AccountantDto> getAllAccountant();
}
