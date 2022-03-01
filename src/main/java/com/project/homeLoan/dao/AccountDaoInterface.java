package com.project.homeLoan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.homeLoan.model.AccountModel;

public interface AccountDaoInterface extends JpaRepository<AccountModel, Long>{

}
