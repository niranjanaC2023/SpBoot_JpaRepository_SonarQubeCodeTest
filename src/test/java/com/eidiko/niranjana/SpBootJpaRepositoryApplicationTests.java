package com.eidiko.niranjana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eidiko.niranjana.service.ICustomerDetailsService;

@SpringBootTest
class SpBootJpaRepositoryApplicationTests 
{
	@Autowired
	private ICustomerDetailsService custoDetailsService;
	
	
	
}
