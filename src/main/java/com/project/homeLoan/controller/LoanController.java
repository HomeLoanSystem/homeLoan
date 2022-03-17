package com.project.homeLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.homeLoan.common.ResponseHandler;
import com.project.homeLoan.helper.EmiCaculator;
import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.model.LoanModel.Status;
import com.project.homeLoan.model.UserModel;
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
	
	@GetMapping(value = "/updateLoanStatus/{id}")
	public ResponseEntity<Object> loanStatus(@PathVariable long id)
	{
		Status st=loanService.getLoanStatus(id);
		if(st.equals(Status.PENDING))
		{
			return ResponseHandler.generateResponse("Please submit your property Documents for Verification! Pending!!",HttpStatus.OK ,st);
		}
		else if(st.equals(Status.REJECTED))
		{
			return ResponseHandler.generateResponse("Your Loan Application Got rejected! Please reveiw banks terms and conditions.", HttpStatus.OK, st);
		}
		else
		{
			return ResponseHandler.generateResponse("Your loan Application is Approved, congrats! Please find the Emi details below !",HttpStatus.OK ,loanService.evaluateEmi(id));
		}
		
	}
}
