package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.model.KycModel;
import com.project.homeLoan.services.KycService;

@RestController
public class KycController {
	
	@Autowired
	private KycService kycService;
	
	@PostMapping(value="/kyc",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addKyc(@RequestBody KycModel kycdata)
	{
		System.out.println(kycdata.getMobile()+" "+kycdata.getEmail()+" "+ kycdata.getUser());
		return kycService.addKyc(kycdata);
	}

}
