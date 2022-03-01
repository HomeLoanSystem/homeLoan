package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value ="/accounts",produces =  MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> setAcount(AccountModel data)
	{
		return new ResponseEntity<>(accountService.setAccount(data),HttpStatus.OK);
	}
	

}
