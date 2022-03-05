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



@Entity
@Table(name = "Users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	public long getId() {
		return id;
	}


	@Column(name = "userName")
	@Size(min = 6, max = 15)
	private String userName;
	
	@Column(name = "password")
	@Size(min = 6, max = 15)
	private String password;
	
	@Column(name = "role")
	private boolean role;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
     
	
	@OneToOne(mappedBy = "user" , fetch = FetchType.LAZY)
	private AccountModel account;
	
    @JsonManagedReference
	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
		this.account = account;
	}

	@JsonManagedReference
	public KycModel getKyc() {
		return kyc;
	}

	public void setKyc(KycModel kyc) {
		this.kyc = kyc;
	}


	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private KycModel kyc;
}
