package com.baochao.Date;

public class Employee {

	private String name;
	private double salary;
	private int id;
	private static int nextId = 1;
	
	public Employee(String n, double s){
		name = n;
		salary = s;
		id = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public int getId(){
		return id;
	}

	public void setId(){
		id = nextId;
		nextId++;
	}
	
	public static int getNextId(){
		return nextId;
	}
	
	public static void main(String[] args){
		Employee e = new Employee("Harry", 5000);
		System.out.println(e.getName()+" " +e.getSalary());
	}
}
