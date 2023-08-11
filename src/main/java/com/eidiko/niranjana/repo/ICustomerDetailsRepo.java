package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;

public interface ICustomerDetailsRepo extends JpaRepository<CustomerDetailsEntity, String>
{

}
