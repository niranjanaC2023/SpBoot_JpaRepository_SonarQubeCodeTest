package com.eidiko.niranjana.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;
import com.eidiko.niranjana.model.CustomerDetailsModel;
import com.eidiko.niranjana.service.ICustomerDetailsService;

@RestController
@RequestMapping("/customer")
public class CustomerDetailsController 
{
	private Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);
	
	@Autowired
	private ICustomerDetailsService service;
	
	
	@PostMapping("/dataSave")
	public ResponseEntity<String> saveCustomerDetails(@RequestBody CustomerDetailsModel customerDetailsModel)
	{
		logger.info("--------saveCustomerDetails in Controller class----------");
		
		// Created Applicaion ID with Date			
		int x = ThreadLocalRandom.current().nextInt();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		String taskId = "CCMS"+x+dtf.format(now);
		String casereferenceNumber = "MSQ"+x;
		
		//Created Date with format
		DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		LocalDateTime noww = LocalDateTime.now();  
		String createdDate = dtff.format(noww);
		
		CustomerDetailsEntity customerDetailsEntity = new CustomerDetailsEntity();
		customerDetailsEntity.setTaskId(taskId);
		customerDetailsEntity.setCaseReferenceNumber(casereferenceNumber);
		customerDetailsEntity.setCifNumber(customerDetailsModel.getCifNumber());
		customerDetailsEntity.setCreatedDate(createdDate);
		customerDetailsEntity.setCivilId(customerDetailsModel.getCivilId());
		customerDetailsEntity.setCustomerName(customerDetailsModel.getCustomerName());
		customerDetailsEntity.setMobileNumber(customerDetailsModel.getMobileNumber());
		customerDetailsEntity.setPassportNumber(customerDetailsModel.getPassportNumber());
				
		logger.info(taskId);
		logger.info(casereferenceNumber);
		logger.info(createdDate);
		
		
		String data = service.registerCustomerData(customerDetailsEntity);
		
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/fetchUsingCIF")
	public ResponseEntity<CustomerDetailsEntity> fetchCustomerDetailsUsingCifNumber(@RequestParam("CIF_NUMBER") String cifNumber)
	{
		CustomerDetailsEntity data = service.fetchCustomerDataUsingCifNumber(cifNumber);
		return ResponseEntity.status(HttpStatus.OK).body(data);		
	}
	
	@GetMapping("/fetchUsingCivilId")
	public ResponseEntity<List<CustomerDetailsEntity>> fetchCustomerDetailsUsingCivilId(@RequestParam("CIVIL_ID") String civilId)
	{
		List<CustomerDetailsEntity> data = service.fetchCustomerDataUsingCivilId(civilId);
		return ResponseEntity.status(HttpStatus.OK).body(data);		
	}
	

}
