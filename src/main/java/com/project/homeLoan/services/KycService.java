package com.project.homeLoan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.KycDaoInterface;
import com.project.homeLoan.model.KycModel;

@Service
public class KycService {
	
	@Autowired
	private KycDaoInterface kycDao;

	public String addKyc(KycModel kycdata) {
		kycDao.save(kycdata);
		return "inserted";
	}

}
