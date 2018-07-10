package com.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annotation.Testobject;

@Repository(value="userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private Testobject testobject;
	

	public void save() {
		System.out.println("UserRepository save......");
		System.out.println(testobject);
	}

	
}
