package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value="/accounts")
	public ResponseEntity<Object> getAccounts()
	{
		return new ResponseEntity<>(accountService.getAccounts(),HttpStatus.OK);
	}
	
	@PostMapping(value ="/addAccount",produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String setAcount(@RequestBody AccountModel data)
	{
		System.out.println(data.getAccountType()+" "+data.getBalance()+" "+data.getBranch());
		System.out.println("User" + data.getUser());
		
		return accountService.setAccount(data);
	}
	

}
