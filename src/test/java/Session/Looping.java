package Session;

public class Looping {

	//printing table of 2
	public static void main(String args[]) {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*2);
			if(i==5) {
				break;
			}

		}
	}
}
