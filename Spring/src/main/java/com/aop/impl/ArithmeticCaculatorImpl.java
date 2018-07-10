package com.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCaculatorImpl implements ArithmeticCaculator{

	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

	public int muti(int i, int j) {
		int result = i * j;
		return result;
	}

}
