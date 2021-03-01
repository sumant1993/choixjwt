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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class UserInfo 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String userName;
	public String password;
	public long userId;
	public String createdAt;
	public String updatedAt;
	public String userType;


}
