package Shapes;

public class Reverse {
	
	public static void main(String args[]) {
		 
		String a = "Saurabh";
		String name = null;
		
		for(int i=a.toCharArray().length-1; i>=0; i--) {
			name= name+a.charAt(i);
			System.out.print(a.charAt(i));
		}
		//System.out.println(name);
		
	}

}
