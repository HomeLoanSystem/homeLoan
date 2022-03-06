package com.project.homeLoan.helper;

public class EmiCaculator {
	
	private static Integer rate = 7;
	
	public static double emiCalculator(long principal, long tenure)
	{
		
	      
        rate=rate/(12*100);  // Per month rate
 
        tenure=tenure*12;    // Converting tenure into months
            
        double emi= (principal*rate*Math.pow(1+rate,tenure))/(Math.pow(1+rate,tenure)-1);
      
        System.out.print(" EMI is= "+emi+"\n");
        return emi;
	}

}
