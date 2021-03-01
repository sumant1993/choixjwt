package com.order.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class AuthEvent 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String uuid;
	public String token;
	public String loginAt;
	public long UserInfoId;
    public String IpAddress;
    public String userAgent;


	

}


