package com.project.homeLoan.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Loan_details")
public class LoanModel {
	private enum Status {
		PENDING,
		CLOSED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loanId", nullable = false)
	private long loanId;
	
	@Column(name="balance", nullable = false)
	private long balance;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="tenure", nullable = false)
	private long tenure;
	
	@Column(name="interest", nullable = false)
	private long interest;
	
	@Column(name="salary", nullable = false)
	private long salary;
	
	@Column(name="loan_sanction_date", nullable = false)
	private String loan_sanction_date;
	
	@Column(name="document",nullable=true)
	private String document;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name= "status")
	private Status status;
	
	public String getDocument() {
		return document;
	}



	public void setDocument(String document) {
		this.document = document;
	}

	
	private final HashMap<String, MultipartFile> details= new HashMap<String,MultipartFile>();
	
	 @JsonAnySetter
	 public void addDetail(String key, MultipartFile value) {
	    this.details.put(key, value);
	 }
	 
	 public HashMap<String, MultipartFile> getDetails() { return this.details; }



	@ManyToOne
	@JoinColumn(name="account",referencedColumnName = "accountNo")
	private AccountModel account;
	
	
	
	public long getLoanId() {
		return loanId;
	}



	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}



	public long getBalance() {
		return balance;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public long getTenure() {
		return tenure;
	}



	public void setTenure(long tenure) {
		this.tenure = tenure;
	}



	public long getInterest() {
		return interest;
	}



	public void setInterest(long interest) {
		this.interest = interest;
	}



	public long getSalary() {
		return salary;
	}



	public void setSalary(long salary) {
		this.salary = salary;
	}



	public String getLoan_sanction_date() {
		return loan_sanction_date;
	}



	public void setLoan_sanction_date(String loan_sanction_date) {
		this.loan_sanction_date = loan_sanction_date;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	@JsonBackReference
	public AccountModel getAccount() {
		return account;
	}



	public void setAccount(AccountModel account) {
		this.account = account;
	}


    @JsonManagedReference
	public EMIModel getEmi() {
		return emi;
	}



	public void setEmi(EMIModel emi) {
		this.emi = emi;
	}


	@OneToOne(mappedBy = "loan")
	private EMIModel emi;
}
