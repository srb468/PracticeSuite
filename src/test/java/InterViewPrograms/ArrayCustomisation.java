package InterViewPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCustomisation {

	public static void main(String[] args) {

		// change this array to {3,5,7,-1,-2,-4,-9}
		int[] a = { -1, 5, 3, 7, -2, -4, -9 };
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();

		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				neg.add(a[i]);
			} else {
				pos.add(a[i]);
			}
		}

		//System.out.println(pos);
		//System.out.println(neg);
		for (int i = neg.size()-1; i >= 0; i--) {

			pos.add(neg.get(i));
		}

		System.out.println(pos);
	}

}
