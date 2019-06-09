package com.practiceSuite;

import java.util.HashMap;

public class ReverseSpecial {

	public static void main(String args[]) {

		HashMap<Integer, Character> col = new HashMap<Integer, Character>();
		String data = "Te@tin@g";
		char[] c = data.toCharArray();
		//char rev = ;
		for (int i = data.toCharArray().length - 1; i >= 0; i--) {

			if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
				System.out.println(c[i]); 
		
			} else {
				col.put(i, c[i]);
			}

		}
		System.out.println(col);
		//System.out.println(rev);
		

	}
}
