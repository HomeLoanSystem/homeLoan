package com.project.homeLoan.model;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	public enum Status {
		PENDING,
		SANCTIONED,
		REJECTED,
		CLOSED,	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loanId")
	private long loanId;
	
	@Column(name="balance", nullable = false)
	private long balance;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="tenure", nullable = false)
	private long tenure;

	@Column(name="salary", nullable = false)
	private long salary;
	
	@Column(name="loan_sanction_date")
	private Date loan_sanction_date;
	
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


	public long getSalary() {
		return salary;
	}



	public void setSalary(long salary) {
		this.salary = salary;
	}



	public Date getLoan_sanction_date() {
		return loan_sanction_date;
	}



	public void setLoan_sanction_date(Date loan_sanction_date) {
		this.loan_sanction_date = loan_sanction_date;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}


	@ManyToOne
	@JoinColumn(name="account_no", referencedColumnName = "accountNo")
	private AccountModel account;
	
	
   
	@JsonBackReference
	public AccountModel getAccount() {
		return account;
	}



	public void setAccount(AccountModel account) {
		this.account = account;
	}


    @JsonManagedReference
	public List<EMIModel> getEmi() {
		return emiList;
	}



	public void setEmi(List<EMIModel> emi) {
		this.emiList = emi;
	}


	@OneToMany(mappedBy = "loan")
	private List<EMIModel> emiList;
}
