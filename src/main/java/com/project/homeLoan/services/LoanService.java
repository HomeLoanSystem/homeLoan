package com.project.homeLoan.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.homeLoan.dao.KycDaoInterface;
import com.project.homeLoan.dao.LoanDaoInterface;
import com.project.homeLoan.helper.EmiCaculator;
import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.model.UserModel;
import com.project.homeLoan.model.LoanModel.Status;

@Service
public class LoanService {
	
	@Autowired
	private LoanDaoInterface loanDao;
	
	@Autowired
	private KycDaoInterface kycDao;

	
	
	@Autowired
	private EmiService emiService;
	
	public void processLoanDetails(LoanModel data) {
		data.setStatus(Status.PENDING);
		loanDao.save(data);
		
	}

	private String documentHandler(HashMap<String, MultipartFile> fileDetails) {
		String folder ="C:\\Users\\sumit\\Desktop\\ubs";
		
		byte[] bytes = null;
		try {
			bytes = fileDetails.get("file").getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathDb= folder+fileDetails.get("file").getOriginalFilename();
		Path path = Paths.get(pathDb);
		try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathDb;
	}

	public String docHandler(MultipartFile doc , long id) {
		
        String folder ="C:\\Users\\sumit\\Desktop\\docs\\";
		
		byte[] bytes = null;
		try {
			bytes = doc.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathDb= folder+doc.getOriginalFilename();
		Path path = Paths.get(pathDb);
		try {
			Files.write(path, bytes);
			System.out.println(pathDb);
			loanDao.updateDoc(pathDb, id);
			//businees logic ignore for doc verification
			loanDao.sanctionLoan(1, id);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathDb;
	}

	public Status getLoanStatus(long id) {
		return loanDao.loanStatus(id);
	}

	public Object evaluateEmi(long id) {
		LoanModel l=loanDao.getEmiData(id);
		AccountModel account=l.getAccount();
		UserModel u= account.getUser();
		Long user_id =u.getId();
		String email = kycDao.getEmail(user_id);
		System.out.println(email);
		double emi = EmiCaculator.emiCalculator(l.getBalance(), l.getTenure());
		double balanceOustanding = (l.getBalance()* l.getTenure())/(12);
		balanceOustanding=balanceOustanding/100;
		double interest= emi-balanceOustanding;
		Date d = new Date();
		loanDao.updateDate(d,id);
		emiService.processEmiDetails(l.getBalance(),emi,l.getTenure(),email,interest,l.getLoan_sanction_date(),l);
		
		return Arrays.asList(emi,emi-balanceOustanding);
	}

	

}
