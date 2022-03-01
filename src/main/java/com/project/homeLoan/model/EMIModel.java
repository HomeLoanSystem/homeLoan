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

@Entity
@Table(name = "EMI")
public class EMIModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emiID", nullable = false)
	private long emiID;
	
	@Column(name="amount", nullable = false)
	private long amount;
	
	@Column(name="emi_date", nullable = false)
	private String emi_date;
	
	@Column(name="next_emi_date", nullable = false)
	private String next_emi_date;
	
	@Column(name="remaining_amount")
	private long remaining_amount;
	
	@Column(name="interest_amount", nullable = false)
	private long interest_amount;
	
	
	
	@OneToOne
	@JoinColumn(name="loanId",referencedColumnName = "loanId")
	private LoanModel loan;
}
