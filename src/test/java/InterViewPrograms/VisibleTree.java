package InterViewPrograms;

import java.util.Arrays;

public class VisibleTree {

	public static void main(String args[]) {
		int count = 0;
		int[] a = { 3, 5, 7, 4, 9, 6, 1 };
		int max = Arrays.stream(a).max().getAsInt();
		// System.out.println(max);
		for (int i = 0; i < a.length; i++) {

			if ((a[i] < max)&&a[i]<a[i+1]) {
				count = count + 1;
			}
			if(a[i]==max) {
				count=count+1;
				break;
			}

		}
		System.out.print(count);
	}
}
