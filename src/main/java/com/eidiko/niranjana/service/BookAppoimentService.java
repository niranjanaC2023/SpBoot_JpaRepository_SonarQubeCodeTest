package com.eidiko.niranjana.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dto.AppointmentFormDTO;
import com.eidiko.niranjana.entity.Appointment;
import com.eidiko.niranjana.entity.Patient;
import com.eidiko.niranjana.repo.IAppointmentRepo;
import com.eidiko.niranjana.repo.IPatientRepo;
@Service
@Transactional
public class BookAppoimentService 
{
	private static Logger logger = LoggerFactory.getLogger(BookAppoimentService.class);
	@Autowired
	private IPatientRepo patientRepo;

	@Autowired
	private IAppointmentRepo appointmentRepo;
	
	public String bookAppointment(AppointmentFormDTO appointmentFormDTO)
	{	
		Patient patient = new Patient();
		patient.setAge(appointmentFormDTO.getAge());
		patient.setGender(appointmentFormDTO.getGender());
		patient.setMobile(appointmentFormDTO.getMobile());	
		patient.setName(appointmentFormDTO.getName());		
		Long patientNo = patientRepo.save(patient).getPatientNo();	
		logger.info("Patient Saved Successfully!!!");
		Appointment appointment = Appointment.builder().date(new Date(System.currentTimeMillis())).doctorNo(101l).patientNo(patientNo).build();	
		Long appointmentNo = appointmentRepo.save(appointment).getAppointmentNo();
		return "Appointment booked Successfully!! With: "+appointmentNo;
	}
	
}
