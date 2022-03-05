package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.services.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	
	@PostMapping(value="/applyForLoan")
	public String applyForLoan(@RequestBody LoanModel data)
	{
		
		return loanService.processLoanDetails(data);    
	}
	
	@PostMapping(value="/upload")
	public String uploadDocument(@RequestBody MultipartFile file)
	{
		String str= loanService.docHandler(file);
		return str;
	}
}
