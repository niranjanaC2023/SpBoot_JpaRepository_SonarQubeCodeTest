package com.eidiko.niranjana.model;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Setter
@Getter
public class CustomerDetailsModel 
{
	@Id
	private String taskId;
	private String caseReferenceNumber;
	private String createdDate;
	private String customerName;
	private String cifNumber;
	private String civilId;
	private String passportNumber;
	private String mobileNumber;
}
