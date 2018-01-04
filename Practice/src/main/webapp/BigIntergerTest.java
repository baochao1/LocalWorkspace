package main.webapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BigIntergerTest {

	public static void main(String[] args) throws IOException{

		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try {
			inputStream = new FileReader("F:\\workspace\\Practice\\src\\main\\webapp\\a.txt");
			outputStream = new FileWriter("F:\\workspace\\Practice\\src\\main\\webappb.txt");
			
			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
			
		}
		
	}
}
