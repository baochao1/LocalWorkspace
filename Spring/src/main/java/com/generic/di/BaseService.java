package com.generic.di;

public class BaseService<T> {

	protected BaseRepository<T> repository;
	
	public void add(){
		System.out.println("adding....");
		System.out.println("repository.........");
	}
}
