package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.homeLoan.common.ResponseHandler;
import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.services.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	
	
	
	@PostMapping(value="/applyForLoan")
	public ResponseEntity<Object> applyForLoan(@RequestBody LoanModel data)
	{
		if( data.getBalance() <= data.getSalary() * 50 )
		{
			loanService.processLoanDetails(data);
			return ResponseHandler.generateResponse("Eligible for Home Loan. Please upload document for verification."  , HttpStatus.OK, data);
		}
		return ResponseHandler.generateResponse("Maximum applicable loan amount exceeded , P.S Apply for loan upto "+data.getSalary() * 50+ " ", HttpStatus.OK, null);   
	}
	
	@PostMapping(value="/upload/{id}")
	public ResponseEntity<Object> uploadDocument(@RequestBody MultipartFile file , @PathVariable long id)
	{
		String str= loanService.docHandler(file , id);
		
				return ResponseHandler.generateResponse("Document uploaded successfully. Will notify once loan sanctioned ", HttpStatus.OK, null);   
	}
}
