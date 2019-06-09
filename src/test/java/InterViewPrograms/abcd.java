package InterViewPrograms;

public class abcd {

	public static void main(String[] args) {

		int i = 1;
		char c;

		for (c = 'a'; c <= 'z'; c++) {
			System.out.println(c + "=" + i);
			i++;
		}

		//read number from a string
		String otp = "Your otp is 9934";
		
		for(int t=0;t<otp.length();t++) {
			if(Character.isDigit(otp.charAt(t))) {
				System.out.print(otp.charAt(t));
			}
			
			
		}
	}

}
