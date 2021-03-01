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
public class UserCredential 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String phoneNumber;
	public String Uuid;

}
