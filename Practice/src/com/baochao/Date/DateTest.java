package com.baochao.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		
		
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		System.out.println(today);
		System.out.println(month);
	}

}
