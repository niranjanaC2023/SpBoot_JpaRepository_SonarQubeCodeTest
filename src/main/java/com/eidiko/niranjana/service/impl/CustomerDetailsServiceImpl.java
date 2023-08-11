package com.eidiko.niranjana.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dao.ICustomerDetailsDao;
import com.eidiko.niranjana.entity.CustomerDetailsEntity;
import com.eidiko.niranjana.service.ICustomerDetailsService;
@Service
public class CustomerDetailsServiceImpl implements ICustomerDetailsService 
{
	private static Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);
	@Autowired
	private ICustomerDetailsDao dao;

	@Override
	public String registerCustomerData(CustomerDetailsEntity customerDetailsEntity) 
	{
		logger.info("-------------registerCustomerData service method");
		return dao.registerCustomerDataInDB(customerDetailsEntity);
	}

	@Override
	public CustomerDetailsEntity fetchCustomerDataUsingCifNumber(String cifNumber) 
	{
		return dao.custfetchCustomerDataUsingCifNumber(cifNumber);
	}
	
	@Override
	public List<CustomerDetailsEntity> fetchCustomerDataUsingCivilId(String civilId) 
	{
		return dao.custfetchCustomerDataUsingCivilId(civilId);
	}


	

}
