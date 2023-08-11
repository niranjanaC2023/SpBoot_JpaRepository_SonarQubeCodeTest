package com.eidiko.niranjana.sevice.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eidiko.niranjana.dao.ICustomerDetailsDao;
import com.eidiko.niranjana.entity.CustomerDetailsEntity;
import com.eidiko.niranjana.service.ICustomerDetailsService;

@SpringBootTest
public class CustomerDetailsServiceImplTest 
{
	@Autowired
	private ICustomerDetailsService customerDetailsService;
	
	@MockBean
	private ICustomerDetailsDao dao;
	
	@BeforeEach
	void setUp()
	{
	//Optional<CustomerDetailsEntity> cust	= Optional.of(new CustomerDetailsEntity("12","CFR34RT","11-07-2023","Raju","072587","008924","NC1234FGH","980822727"));
	CustomerDetailsEntity data = new CustomerDetailsEntity();
	data.setTaskId("12");
	data.setCaseReferenceNumber("CFR34RT");
	data.setCreatedDate("11-07-2023");
	data.setCustomerName("Raju");
	data.setCifNumber("072587");
	data.setCivilId("08924");
	data.setPassportNumber("NC1234FGH");
	data.setMobileNumber("980822748");
	Mockito.when(dao.custfetchCustomerDataUsingCifNumber("072587")).thenReturn(data);
		
	}
	
	@Test
	public void testFetchCustomerDataUsingCifNumber()
	{
		String expectedName = "Raju";
		CustomerDetailsEntity customerDetailsByCIF= customerDetailsService.fetchCustomerDataUsingCifNumber("072587");
		Assertions.assertEquals(expectedName, customerDetailsByCIF.getCustomerName());
	}
	@Test
	public void testFetchCustomerDataUsingCivilId()
	{
		List<String> expectedList = Arrays.asList("12","CFR34RT","11-07-2023","Raju","072587","008924","NC1234FGH","980822727");
		List<CustomerDetailsEntity> cust	= List.of(new CustomerDetailsEntity("12","CFR34RT","11-07-2023","Raju","072587","008924","NC1234FGH","980822727"));
		Mockito.when(dao.custfetchCustomerDataUsingCivilId("072587")).thenReturn(cust);
		List<CustomerDetailsEntity> customerDetailsByCIVIL = customerDetailsService.fetchCustomerDataUsingCivilId("08924");
		for(CustomerDetailsEntity actualLIst:customerDetailsByCIVIL)
		{
			Assertions.assertEquals(expectedList, actualLIst);
		}
	}
}
