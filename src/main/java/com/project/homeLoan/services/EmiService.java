package com.project.homeLoan.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.homeLoan.dao.EmiModelDaoInterface;
import com.project.homeLoan.model.EMIModel;
import com.project.homeLoan.model.LoanModel;

@Service
public class EmiService {

	@Autowired
	private EmiModelDaoInterface emiDao;
	
	@Autowired
	private JavaMailSender mailSender;
	

	public void processEmiDetails(long balance, double emi, long tenure, String email, double interest,
			Date loan_sanction_date, LoanModel l) {
	    EMIModel eModel= new EMIModel();
		eModel.setAmount(Double.valueOf(emi).longValue());
		eModel.setInterest_amount(Double.valueOf(interest).longValue());
		eModel.setLoan(l);
		eModel.setEmi_date(loan_sanction_date);
		eModel.setNext_emi_date(loan_sanction_date);
		emiDao.save(eModel);
		sendMail("srshengokar@gmail.com",email,emi,interest);
		
		
	}
	
	private void sendMail(String from, String to,double emi, double interest) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Congrats! Emi got approved");
		message.setText("Your emi for first month will be! " + emi +"and interest is "+interest);
		mailSender.send(message);
		System.out.println("mail sent");
		// TODO Auto-generated method stub
		
	}


	
}
