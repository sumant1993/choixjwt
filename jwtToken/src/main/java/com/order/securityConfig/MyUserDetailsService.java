package com.order.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.order.Entity.UserCredential;
import com.order.Repo.UserCredentialRepo;

@Service
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserCredentialRepo repo;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String PhoneNumber) throws UsernameNotFoundException {
		
		UserCredential user = repo.findByPhoneNumber(PhoneNumber);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(user);
	}

}
