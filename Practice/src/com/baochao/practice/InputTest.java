package com.baochao.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputTest {

	public static void main(String[] args){
//		Scanner in = new Scanner(System.in);
		
//		System.out.println("what's your name?");
//		String name = in.nextLine();
		
//		Console console = System.console();
//		char[] password = console.readPassword("password:");
//		System.out.println("how old are you?");
//		int age = in.nextInt();
//		System.out.println("Hello," + name + ", Next year, you'll be " + (age+1));
		try {
			Scanner in = new Scanner(new File("C:\\Users\\Chao Bao\\Desktop\\fortest.txt"));
			String name = in.nextLine();
			System.out.println(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
