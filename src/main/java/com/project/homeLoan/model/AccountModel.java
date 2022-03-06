package com.project.homeLoan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Account")
public class AccountModel {

	

	@Id
	@GenericGenerator(name="sequence_generator", strategy="com.project.homeLoan.generator.AccountNumberGenerator")
	@GeneratedValue(generator = "sequence_generator")
	@Column(name="accountNo")
	private long accountNo;
	

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name = "branch")
	private String branch;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "balance")
	private long balance;
	
	@Column(name = "ifsc")
	private String ifsc;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserModel user;

	public void setUser(UserModel user) {
		this.user = user;
	}

	@JsonBackReference
	public UserModel getUser() {
		return user;
	}
	
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	//in mappedBy use object name created in referncing table(loanModel.java ) 
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<LoanModel> loans;

	
	public List<LoanModel> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanModel> loans) {
		this.loans = loans;
	} 
}
