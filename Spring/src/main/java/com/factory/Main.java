package com.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new  ClassPathXmlApplicationContext("staticFactory.xml");
		
		Car car = (Car)ctx.getBean("car2");
		
		System.out.println(car.getBrand().toString() + "   " + car.getPrice());
	}
}