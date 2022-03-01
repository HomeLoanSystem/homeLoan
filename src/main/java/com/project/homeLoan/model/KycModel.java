package com.project.homeLoan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Kyc_details")
public class KycModel {

	@Id
	@Column(name="mobile", nullable = false)
	private long mobile;
	
	@Column(name = "email")
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Invalid email address")
	private String email;
	
	@Column(name = "pan")
	@Pattern(regexp = "[a-z0-9]{5,10}", message = "Invalid pan number")
	private String pan;
	
	@Column(name = "aadhar")
	private String aadhar;
	
	
	
	@OneToOne
	@JoinColumn(name="userId", referencedColumnName = "id")
	private UserModel user;
}
