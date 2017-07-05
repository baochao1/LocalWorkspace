package com.baochao.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		
		Calendar calendar = new GregorianCalendar();
		System.out.println(calendar.get(Calendar.AM));
//		calendar.get(Calendar.AM);
	}

}
