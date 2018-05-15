package setTest;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		Set<String> setTest = new HashSet<String>();
		for (int i = 0; i < 10; i++) {
			setTest.add(String.valueOf(i));
		}
		
		for (String string : setTest) {
			System.out.println(string);
		}
	}
}
