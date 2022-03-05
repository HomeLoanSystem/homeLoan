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

import com.fasterxml.jackson.annotation.JsonBackReference;

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



	public long getEmiID() {
		return emiID;
	}



	public void setEmiID(long emiID) {
		this.emiID = emiID;
	}



	public long getAmount() {
		return amount;
	}



	public void setAmount(long amount) {
		this.amount = amount;
	}



	public String getEmi_date() {
		return emi_date;
	}



	public void setEmi_date(String emi_date) {
		this.emi_date = emi_date;
	}



	public String getNext_emi_date() {
		return next_emi_date;
	}



	public void setNext_emi_date(String next_emi_date) {
		this.next_emi_date = next_emi_date;
	}



	public long getRemaining_amount() {
		return remaining_amount;
	}



	public void setRemaining_amount(long remaining_amount) {
		this.remaining_amount = remaining_amount;
	}



	public long getInterest_amount() {
		return interest_amount;
	}



	public void setInterest_amount(long interest_amount) {
		this.interest_amount = interest_amount;
	}


    @JsonBackReference
	public LoanModel getLoan() {
		return loan;
	}



	public void setLoan(LoanModel loan) {
		this.loan = loan;
	}
	
}
