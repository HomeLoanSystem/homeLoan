package com.project.homeLoan.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.homeLoan.model.EMIModel;

public interface EmiModelDaoInterface extends JpaRepository<EMIModel, Long> {

	@Transactional
	@Query(value = "SELECT * from emi WHERE loan_id=? order By emiid DESC LIMIT 1;",nativeQuery = true)
	EMIModel getLatestEntryByLoanId(long id);
	
	@Transactional
	@Query(value = "SELECT * from emi where emi_date=?",nativeQuery = true)
	List<EMIModel> getListEmiMatchingDates(Date d);

}
