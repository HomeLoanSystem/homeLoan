package com.project.homeLoan.common;

import java.text.SimpleDateFormat;

public class DateFormater {
	private  static SimpleDateFormat df=null;
	
	public static SimpleDateFormat getInstance()
	{
		if(df==null)
		{
			df= new SimpleDateFormat("yyyy-MM-dd");
		}
		return df;
	}

}
