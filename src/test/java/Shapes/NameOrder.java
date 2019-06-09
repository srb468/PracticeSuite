package Shapes;

import java.util.Arrays;
import java.util.Collections;

public class NameOrder {

	public static void main(String args[]) {

		String name = "mobile";
		char [] a = name.toCharArray();
		
		Arrays.sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]);
		}
		//Arrays.sort(a, Collections.reverseOrder());
		
	}
}
