package Shapes;

public class MobileNoaD {

	public static void main(String[] args) {

		int sum = 0;
		String mobile = "7503707712";
		// char[] mob = mobile.toCharArray();

		for (int i = 0; i < mobile.toCharArray().length; i++) {

			sum = sum + Character.getNumericValue(mobile.charAt(i));

		}
		System.out.println(sum); 
		
		int rem= sum%10;
		int div =sum/10;
		
		System.out.println(rem+div);
	}

}
