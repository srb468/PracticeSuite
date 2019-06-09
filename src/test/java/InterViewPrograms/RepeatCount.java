package InterViewPrograms;

import java.util.HashMap;

public class RepeatCount {

	public static void main(String[] args) {
		int count = 0;
		HashMap<Character,Integer> container = new HashMap<Character,Integer>();
		String s = "makemytriptest";
		char[] toChar = s.toCharArray();
		int charLen = toChar.length;

		for (int i = 0; i <= charLen - 1; i++) {

			for (int j = 0; j <= charLen - 1; j++) {
				if (toChar[i] == toChar[j]) {
					count = count + 1;

				}
			}
			//System.out.println(toChar[i] + " repeated for times: " + count);
			container.put(toChar[i],count);
			count = 0;
		}
		
		System.out.println(container);

	}

}
