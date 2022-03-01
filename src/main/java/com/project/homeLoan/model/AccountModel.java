package com.project.homeLoan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Account")
public class AccountModel {

	@Id
	@GenericGenerator(name="sequence_generator", strategy="com.project.homeLoan.generator.AccountNumberGenerator")
	@GeneratedValue(generator = "sequence_generator")
	@Column(name="accountNo", updatable = false, nullable = false)
	private long accountNo;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "balance")
	private long balance;
	
	@Column(name = "ifsc")
	private String ifsc;
	
	@OneToOne
	@JoinColumn(name="userId",referencedColumnName ="id" )
	private UserModel user;
	
	//in mappedBy use object name created in referncing table(loanModel.java ) 
	@OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL)
	private List<LoanModel> loans; 
}
