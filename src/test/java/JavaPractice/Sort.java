package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class Sort {

	//@Test(priority=0)
	public void sorting() {
		
		int a[] = { 4, 26, 3, 2, 11, 5, 7 };
		Arrays.sort(a);
		System.out.print(Arrays.toString(a));

	}
	@Test(priority=1)
	public void ListSort() {
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(6);
		b.add(2);
		b.add(56);
		b.add(22);
		b.add(10);
		b.add(13);
		
		System.out.println(b);
		Collections.sort(b);
		System.out.println(b);
		Collections.reverse(b);
		System.out.println(b);
	}
		
}
