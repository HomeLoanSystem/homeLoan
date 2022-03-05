package com.project.homeLoan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.KycDaoInterface;
import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.model.KycModel;

import java.util.List;
@Service
public class KycService {
	
	@Autowired
	private KycDaoInterface kycDao;

	public List<KycModel> getAll() {
		
		return  kycDao.findAll();
	}

	public KycModel getById(long id) {
		
		return kycDao.getById(id);
	}

	public KycModel setKycDetails(KycModel data) {
		
		return kycDao.save(data);
	}

}
