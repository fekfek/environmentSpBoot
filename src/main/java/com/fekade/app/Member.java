package com.fekade.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Cannot be blank or null")
	private String name;
	@NotBlank(message="Cannot be blank")
	@Email
	@Size(min=3)
	private String email;
	@NotBlank(message="Cannot be blank or null")
	private String password;
	private String phone;
	private String city;
	@Column(name="membershiptype")
	private String membershipType;
	@Column(name="contributionremark")
	private String contributionRemark;

}
