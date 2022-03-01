package com.project.homeLoan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.homeLoan.model.LoanModel;

public interface LoanDaoInterface extends JpaRepository<LoanModel, Long>{

}
