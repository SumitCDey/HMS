package com.wellaxis.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public Random getRandomNum(int size) {

		Random ranNum=new Random();
		ranNum.nextInt(size);
		return ranNum;
		
	}
	public String getSystemDateYYYYDDMM(String format) {

		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		String date=sdf.format(dateObj);
		return date;
	}	

}
