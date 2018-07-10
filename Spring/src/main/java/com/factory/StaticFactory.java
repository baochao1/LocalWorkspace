package com.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticFactory {
	private static Map<String, Car> car = new HashMap<String, Car>();
	
	static{
		car.put("audi", new Car("audi",300000));
		car.put("ford", new Car("ford",400000));
	}

	public static Car getCar(String name) {
		
		return car.get(name);
		
	}
}
