package com.project.homeLoan.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.model.LoanModel.Status;

public interface LoanDaoInterface extends JpaRepository<LoanModel, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "update loan_details SET document=? WHERE loan_id = ?",nativeQuery = true)
    public void updateDoc(String str,long a);
	
	@Transactional
	@Query(value = "SELECT status from loan_details WHERE loan_id = ?",nativeQuery = true)
	public Status loanStatus(long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE loan_details SET status=? WHERE  loan_id= ?",nativeQuery = true)
	public void updateLoanStatus(int st,long id);

	@Transactional
	@Query(value = "SELECT * from loan_details where loan_id=?",nativeQuery = true)
	public LoanModel getEmiData(long id);

	@Transactional
	@Modifying
	@Query(value= "UPDATE loan_details SET loan_sanction_date=? WHERE loan_id=?",nativeQuery = true)
	public void updateDate(Date d, long id);

	@Transactional
	@Query(value = "Select document from loan_details WHERE loan_id=?",nativeQuery = true)
	public String checkDocStatus(long id);
	

}
