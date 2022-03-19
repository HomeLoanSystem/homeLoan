package com.project.homeLoan.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.homeLoan.common.DateFormater;
import com.project.homeLoan.dao.EmiModelDaoInterface;
import com.project.homeLoan.dao.KycDaoInterface;
import com.project.homeLoan.dao.LoanDaoInterface;
import com.project.homeLoan.helper.EmiCaculator;
import com.project.homeLoan.model.AccountModel;
import com.project.homeLoan.model.EMIModel;
import com.project.homeLoan.model.LoanModel;
import com.project.homeLoan.model.UserModel;

@Service
public class EmiService {

	@Autowired
	private EmiModelDaoInterface emiDao;
	
	@Autowired
	private LoanDaoInterface loanDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private KycDaoInterface kycDao;
	
	public Object evaluateEmi(long id) {
		LoanModel l=loanDao.getEmiData(id);
		AccountModel account=l.getAccount();
		UserModel u= account.getUser();
		Long user_id =u.getId();
		String email = kycDao.getEmail(user_id);
		System.out.println(email);
		EMIModel e=emiDao.getLatestEntryByLoanId(id);
		long amount;
		Date emiDate;
		if(e==null) {
			amount=l.getBalance();
			emiDate=l.getLoan_sanction_date();
		}
		else{
			amount = e.getRemaining_amount();
			emiDate=e.getNext_emi_date();
		}
		System.out.println("amount is "+ amount);
		double emi = EmiCaculator.emiCalculator(amount, l.getTenure());
		double balanceOustanding = (amount* l.getTenure())/(12);
		balanceOustanding=balanceOustanding/100;
		double interest= emi-balanceOustanding;
	    processEmiDetails(amount,emi,l.getTenure(),email,interest,emiDate,l,balanceOustanding);
		
		return Arrays.asList(emi,emi-balanceOustanding);
	}

	public void processEmiDetails(long balance, double emi, long tenure, String email, double interest,
			Date emiDate, LoanModel l, double balanceOustanding) {
	    EMIModel eModel= new EMIModel();
		eModel.setAmount(Double.valueOf(emi).longValue());
		eModel.setInterest_amount(Double.valueOf(interest).longValue());
		eModel.setLoan(l);
		eModel.setEmi_date(processDate(emiDate, 1));
		eModel.setNext_emi_date(processDate(emiDate, 30));
		eModel.setRemaining_amount(balance - Double.valueOf(balanceOustanding).longValue());
		eModel.setEmi_paid_date(new Date());
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

	private Date processDate(Date loan_sanction_date, int days) {

		Date d = loan_sanction_date;
		SimpleDateFormat sdf = DateFormater.getInstance();
		String dt=sdf.format(d);
		System.out.println("Current" +dt);
		Calendar c = Calendar.getInstance();

		try {
		c.setTime(sdf.parse(dt));
		} catch (ParseException e) {

		e.printStackTrace();
		}

		c.add(Calendar.DATE, days);  // number of days to add

		dt = sdf.format(c.getTime());
		try {
		d= sdf.parse(dt);
		System.out.println("Date " + d);
		} catch (ParseException e) {

		e.printStackTrace();
		}
		return d;
		}
	
	public void generateEmiDetails(long id) {
		
		
	}


	
}
