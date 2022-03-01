package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.services.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
}
