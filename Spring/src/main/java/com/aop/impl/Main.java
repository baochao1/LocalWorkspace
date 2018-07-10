package com.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArithmeticCaculator arithmeticCaculator = ctx.getBean(ArithmeticCaculator.class);
		
		int result = arithmeticCaculator.add(3,6);
		System.out.println("result: " + result);
		
		int result1 = arithmeticCaculator.div(6, 2);
		System.out.println("result1: " + result1);
		
		
	}
	
}
