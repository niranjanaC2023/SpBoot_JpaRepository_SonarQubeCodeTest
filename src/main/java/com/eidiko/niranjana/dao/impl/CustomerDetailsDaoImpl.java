package com.eidiko.niranjana.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dao.ICustomerDetailsDao;
import com.eidiko.niranjana.entity.CustomerDetailsEntity;
@Service
public class CustomerDetailsDaoImpl implements ICustomerDetailsDao 
{
	@Autowired
	private JdbcTemplate jt;

	private Logger logger = LoggerFactory.getLogger(CustomerDetailsDaoImpl.class);
	
	@Override
	public String registerCustomerDataInDB(CustomerDetailsEntity customerDetailsEntity) 
	{
		int count=0;
		String insertQuery = "insert into ccms_customerdetailsentity(task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number)values(?,?,?,?,?,?,?,?)";
		logger.info("-------------registerCustomerDataInDB dao method===========");
		count = jt.update(insertQuery,customerDetailsEntity.getTaskId(),customerDetailsEntity.getCaseReferenceNumber(),customerDetailsEntity.getCreatedDate(),customerDetailsEntity.getCustomerName(),customerDetailsEntity.getCifNumber(),customerDetailsEntity.getCivilId(),customerDetailsEntity.getPassportNumber(),customerDetailsEntity.getMobileNumber());
		return "data inserted "+count;
	}


	@Override
	public CustomerDetailsEntity custfetchCustomerDataUsingCifNumber(String cifNumber)
	{	
		CustomerDetailsEntity data = null;
			if(cifNumber.length()==6 )
			{
				String selectQuery = "select task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number from ccms_customerdetailsentity where cif_number=?";
				data = jt.queryForObject(selectQuery,new BeanPropertyRowMapper<CustomerDetailsEntity>(CustomerDetailsEntity.class),cifNumber);
			}
			else {
				logger.info("CIF should be 6 digit");
			}
		return data;
	}
	@Override
	public List<CustomerDetailsEntity> custfetchCustomerDataUsingCivilId(String civilId)
	{	
		List<CustomerDetailsEntity> data = null;
			if(civilId.length()==8 )
			{
				String selectQuery = "select task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number from ccms_customerdetailsentity where civil_id=?";
				data = jt.query(selectQuery, new Object[] { civilId },BeanPropertyRowMapper.newInstance(CustomerDetailsEntity.class));
			}
			else {
				logger.info("CivilID should be 8 digit");
			}
		return data;
	}


	


	
}
