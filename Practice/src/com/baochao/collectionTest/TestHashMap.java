package com.baochao.collectionTest;

import java.util.HashMap;
import java.util.Map.Entry;

public class TestHashMap {
	public static void main(String[] args) {
		HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
		
		Dog dog1 = new Dog("red");
		Dog dog2 = new Dog("black");
		Dog dog3 = new Dog("white");
		Dog dog4 = new Dog("white");
		
		hashMap.put(dog1, 10);
		hashMap.put(dog2, 15);
		hashMap.put(dog3, 5);
		hashMap.put(dog4, 20);
		
		System.out.println(hashMap.size());
		
		for (Entry<Dog, Integer> dog : hashMap.entrySet()) {
			System.out.println(dog.getKey().toString() + "-" + dog.getValue());
		}
	}
}


class Dog {
	String color;
	
	Dog(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color + "dog";
	}
}