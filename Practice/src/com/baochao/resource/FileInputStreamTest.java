package com.baochao.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream in = null;
		int b = 0;
//				FileInputStream("D\\:\\what.java");
		try {
			in = new FileInputStream("D:\\what.java");
		} catch (FileNotFoundException  e) {
			System.out.println("can not find paticular file");
			System.exit(-1);
		}
		
		try {
			while ((b=in.read())!=-1) {
				System.out.println((char)b);
			}
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("read the file fail");
		}
	}
}
