package com.project.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.project.homeLoan.services.EmiService;

@RestController
public class EmiController {

	@Autowired
	private EmiService emiService;
}