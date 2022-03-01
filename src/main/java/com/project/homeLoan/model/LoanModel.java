package com.project.homeLoan.model;

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
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name= "status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="account",referencedColumnName = "accountNo")
	private AccountModel account;
	
	
	
	@OneToOne(mappedBy = "loan",cascade = CascadeType.ALL)
	private EMIModel emi;
}
