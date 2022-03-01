package com.project.homeLoan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.homeLoan.dao.AccountDaoInterface;
import com.project.homeLoan.model.AccountModel;

@Service
public class AccountService {

	@Autowired
	private AccountDaoInterface accountDao;

	public List<AccountModel> getAccounts() {
		
		return accountDao.findAll();
	}

	public String setAccount(AccountModel data) {
             accountDao.save(data);		
		
		return "Account Details added successfully";
	}
}
