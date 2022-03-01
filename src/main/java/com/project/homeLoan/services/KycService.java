package com.project.homeLoan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.KycDaoInterface;

@Service
public class KycService {
	
	@Autowired
	private KycDaoInterface kycDao;

}
