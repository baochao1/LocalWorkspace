package com.baochao.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(date);
//		
//		Calendar calendar = new GregorianCalendar();
//		System.out.println(calendar.get(Calendar.AM));
//		calendar.get(Calendar.AM);
		
//		
//		GregorianCalendar calendar = new GregorianCalendar(2010,12,12);
//		Date hireDay = calendar.getTime();
//		System.out.println(hireDay.toString());
		
		
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		System.out.println(today);
		System.out.println(month);
	}

}
