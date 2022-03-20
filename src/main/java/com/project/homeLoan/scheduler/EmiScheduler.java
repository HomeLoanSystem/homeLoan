package com.project.homeLoan.scheduler;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.homeLoan.common.DateFormater;
import com.project.homeLoan.dao.EmiModelDaoInterface;
import com.project.homeLoan.model.EMIModel;
import com.project.homeLoan.services.EmiService;


@Component
public class EmiScheduler {
	
	@Autowired
	private EmiModelDaoInterface emiDao;
	
	@Autowired
	private EmiService emiService;
	
	@Scheduled(cron = "0 0 12 * * ?")
	public void scheduleEmi()
	{
		System.out.println("triggered scheduler");
		String str = DateFormater.getInstance().format(new Date());
		Date d=null;
		try {
			d = DateFormater.getInstance().parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("date is "+ d);
		List<EMIModel> l=emiDao.getListEmiMatchingDates(d);
		for(int i=0;i<l.size();i++) {
//			System.out.println(l.get(i).getEmi_date()+" yesss");
			emiService.evaluateEmi(l.get(i).getLoan().getLoanId());
		}
		
	}

}
