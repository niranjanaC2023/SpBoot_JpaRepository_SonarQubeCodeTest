package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;

public interface ICustomerDetailsService 
{
	public String registerCustomerData(CustomerDetailsEntity customerDetailsEntity);

	public CustomerDetailsEntity fetchCustomerDataUsingCifNumber(String cifNumber);
	public List<CustomerDetailsEntity> fetchCustomerDataUsingCivilId(String civilId);
}
