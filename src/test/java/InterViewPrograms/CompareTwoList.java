package InterViewPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> a1 = new ArrayList<>();
		List<Integer> a2 = new ArrayList<>();

		a1.add(545);
		a1.add(1344);
		a1.add(2411);
		a1.add(3000);
		a1.add(2344);

		a2.addAll(a1);

		Collections.sort(a2);
		System.out.println(a1);
		System.out.println(a2); 
		
		if (a1.size() == a2.size()) {
			for(int i=0;i<a1.size();i++) {
				if((a1.get(i)==a2.get(i))) {
					System.out.println("matched");
					
				}
				else {
					System.out.println("not matched");
					break;
				}
			}
		}

	}

}
