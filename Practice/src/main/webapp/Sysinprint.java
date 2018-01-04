package main.webapp;

import org.junit.Test;

public class Sysinprint {


	@Test
	public void initA(){
		int a = 2;
		doubleA(a);
		System.out.println(a);
	}
	

	void doubleA(int a){
		a = a*2;
	}
}
