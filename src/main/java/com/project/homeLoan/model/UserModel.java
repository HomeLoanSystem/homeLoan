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

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private AccountModel account;
	

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private KycModel kyc;
}
