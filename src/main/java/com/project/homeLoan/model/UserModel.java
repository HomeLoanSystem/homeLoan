package com.project.homeLoan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "userName")
	@Size(min = 6, max = 15)
	private String userName;
	
	@Column(name = "password")
	@Size(min = 6, max = 15)
	private String password;
	
	@Column(name = "role")
	private boolean role;
	

	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
	private AccountModel account;

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private KycModel kyc;
}
