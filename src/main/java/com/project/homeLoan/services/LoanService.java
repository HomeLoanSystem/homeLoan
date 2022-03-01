package com.project.homeLoan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.LoanDaoInterface;

@Service
public class LoanService {
	
	@Autowired
	private LoanDaoInterface loanDao;

}
