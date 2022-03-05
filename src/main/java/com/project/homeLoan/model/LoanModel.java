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

@Entity
@Table(name = "Loan_details")
public class LoanModel {
	private enum Status {
		PENDING,
		CLOSED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	
	@OneToOne(mappedBy = "loan",cascade = CascadeType.ALL)
	private EMIModel emi;
}
