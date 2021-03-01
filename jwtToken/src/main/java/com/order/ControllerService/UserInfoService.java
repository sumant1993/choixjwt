package com.order.ControllerService;

import com.order.Entity.IdDto;
import com.order.JwtService.JwtUtil;
import com.order.controller.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.order.Entity.AuthEvent;
import com.order.Entity.UserCredential;
import com.order.Entity.UserInfo;
import com.order.Repo.AuthEventRepo;
import com.order.Repo.UserCredentialRepo;
import com.order.Repo.UserInfoRepo;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Id;
import java.util.List;


@Service
public class UserInfoService 
{
	@Autowired
	public RestTemplate restTemplate;


	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

   @Autowired
   public UserInfoRepo userInfoRepo;
   
   @Autowired
   public UserCredentialRepo userCred;
	
   @Autowired
   public AuthEventRepo authrepo;
   
   public boolean ifUserPresent(String username) {
	   boolean  isPresent = false;

	   UserInfo user =userInfoRepo.findByUserName(username);
	   if(user == null) {
		   isPresent = true;
	   }
	   System.out.println(isPresent+" in service block");
	   return isPresent;
  }

  public void createUserInfoService(UserInfo userInfo) {
	  userInfoRepo.save(userInfo);
	  System.out.println(userInfo);

  }
  public void CreateAuthEventService(AuthEvent authEvent) {
   	System.out.println("2");
	  authrepo.save(authEvent);
  }

  public List<UserInfo> alluser(){
   	return userInfoRepo.findAll();
  }

  public long FindIdByUsingPhone(String phone){
   	System.out.println("1");
   	UserInfo user = userInfoRepo.findByUserName(phone);
   	return  user.getId();
  }

  public String generateToken(AuthRequest authRequest) throws Exception {
	  try {
		  authenticationManager.authenticate(
				  new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUuid())
		  );
	  } catch (Exception ex) {
		  throw new Exception("invalid phone/uuid");
	  }

	  return  jwtUtil.generateToken(authRequest.getUserName());
  }

  public UserInfo userFindByPhone(String phone){
   	UserInfo user = userInfoRepo.findByUserName(phone);
	  IdDto object= restTemplate.getForObject("http://localhost:9001/user/customer/getCustomerId/"+phone, IdDto.class);
	  System.out.println(object);
	  user.setUserId(object.getId());
	  userInfoRepo.save(user);
   	return userInfoRepo.findByUserName(phone);
  }


   
}
