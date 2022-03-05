package com.project.homeLoan.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.model.KycModel;
import com.project.homeLoan.services.KycService;

import java.util.List;

@RestController
public class KycController {
	
	@Autowired
	private KycService kycService;

	@GetMapping("/kycDetails")
	public List<KycModel> getAll() {
	    return kycService.getAll();
	}
	
	
	@GetMapping(value="/kycDetails/{id}")
	public ResponseEntity<KycModel> getKycById(@PathVariable long id)
	{
		  try {
			  KycModel kyc = kycService.getById(id);
		        return new ResponseEntity<KycModel>(kyc, HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<KycModel>(HttpStatus.NOT_FOUND);
		    }      
	}
	
	@PostMapping(value ="/addKyc",produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity<KycModel> setAcount(@RequestBody KycModel data)
	{
		 try {
		        
		        return new ResponseEntity<KycModel>(kycService.setKycDetails(data),HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<KycModel>(kycService.setKycDetails(data),HttpStatus.NOT_FOUND);
		    }      
		
	}
}
