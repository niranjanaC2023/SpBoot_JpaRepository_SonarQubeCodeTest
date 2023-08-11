package com.eidiko.niranjana.dao;

import java.util.List;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;

public interface ICustomerDetailsDao 
{
	public String registerCustomerDataInDB(CustomerDetailsEntity customerDetailsEntity);
	
	public CustomerDetailsEntity custfetchCustomerDataUsingCifNumber(String cifNumber);
	public List<CustomerDetailsEntity> custfetchCustomerDataUsingCivilId(String civilId);

}
