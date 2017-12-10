package com.baochao.collectionTest;

import java.util.Map.Entry;
import java.util.TreeMap;

class Dogger implements Comparable<Dogger>{
	String color;
	int size;
 
	Dogger(String c, int s) {
		color = c;
		size = s;
	}
 
	public String toString(){	
		return color + " dog";
	}
 
	@Override
	public int compareTo(Dogger o) {
		return  o.size - this.size;
	}

}
 
public class TesttreeMap {
	public static void main(String[] args) {
		Dogger d1 = new Dogger("red", 30);
		Dogger d2 = new Dogger("black", 20);
		Dogger d3 = new Dogger("white", 10);
		Dogger d4 = new Dogger("white", 40);
 
		TreeMap<Dogger, Integer> treeMap = new TreeMap<Dogger, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);
 
		for (Entry<Dogger, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
