package com.project.homeLoan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="accountNo",referencedColumnName ="accountNo" )
	private AccountModel account;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Kyc_details", referencedColumnName = "mobile")
	private KycModel kyc;
}
