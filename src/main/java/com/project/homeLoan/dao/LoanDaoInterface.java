package com.project.homeLoan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.homeLoan.model.LoanModel;

public interface LoanDaoInterface extends JpaRepository<LoanModel, Long>{
	@Query(value = "update loan_details SET document=? WHERE loan_id = ?",nativeQuery = true)
    public String updateDoc(String str,long a);

}
