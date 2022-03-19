package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.services.EmiService;

@RestController
public class EmiController {

	@Autowired
	private EmiService emiService;
	
//	@GetMapping(value ="/triggerEmi/{id}" , produces= MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> getEmiDetails(@PathVariable long id)
//	{
//	    emiService.generateEmiDetails(id);	
//	}
}
