
package com.project.homeLoan.helper;

import java.text.DecimalFormat;


public class EmiCaculator {
	
	private static double rate = 7;
	private static DecimalFormat df=null;
	
	public static DecimalFormat getInstance()
	{
		if(df==null)
		{
			df= new DecimalFormat("#.####");
		}
			return df;
	}
	public static double emiCalculator(long principal, long tenure)
	{
		
	      
        rate=rate/12;  // Per month rate
        System.out.println("rate is "+rate);
        rate=rate/100;
        DecimalFormat f=getInstance();
        rate=Double.valueOf(f.format(rate)); 
        System.out.println("rate is "+rate);
 
        tenure=tenure*12;    // Converting tenure into months
        System.out.println("tenure  is "+tenure);
            
        double n = Math.pow(1+rate, tenure);
        double d = Math.pow(1+rate, tenure);
        double emi_n= (principal*rate*n);
        System.out.println("emi _n is "+ emi_n);
        double res= emi_n/(d-1);
        res=Double.valueOf(f.format(res));
        
      
        System.out.print(" EMI is= "+res+"\n");
        return res;
	}

}
