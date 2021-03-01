package com.order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.Entity.UserCredential;

public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer>
{


	UserCredential findByPhoneNumber(String phoneNumber);
	
}
