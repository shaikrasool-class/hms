package com.rest.java.dao;

import java.util.List;

import com.rest.java.entity.Accountant;

public interface AccountantDao {

	public Accountant addAccountant(Accountant accountant);
	
	public Accountant updateAccountant(Accountant accountant);
	
	public Accountant getOneAccountant(Integer acId);
	
	public Accountant deleteAccountant(Integer acId);
	
	public List<Accountant> getAllAccountant();

	
}
