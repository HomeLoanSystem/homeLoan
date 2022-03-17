package com.project.homeLoan.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.homeLoan.model.KycModel;


public interface KycDaoInterface extends JpaRepository<KycModel, Long>{

	@Transactional
	@Query(value ="SELECT email from kyc_details where user_id = ?",nativeQuery = true)
	public String getEmail(Long user_id);

}
