package listTest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			aList.add(String.valueOf(i));
		}
		ListIterator<String> iterator = aList.listIterator();
		iterator.add("haode");
		while (iterator.hasNext()) {
			iterator.set(iterator.next() + "ai");
			System.out.print(iterator.next() + "  ");
			System.out.println(iterator.nextIndex());
		}
		System.out.println(aList);
		
		ListIterator<String> bIterator = aList.listIterator();
		while (bIterator.hasNext()) {
			System.out.println(bIterator.next());
		}
	}
}
