package JavaPractice;

public class mainn {

	public static void main(String[] args) {

		parent p = new Child();
		//Child c= new Child();
		
		Child c = (Child)p;
		c.minus();
	}

}
