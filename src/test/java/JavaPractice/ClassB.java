package JavaPractice;

public class ClassB extends Animal{

	String name = "Vaibhav";
	int a = 6;
	
	public void print() {
		System.out.println("Name is : " +name);
		System.out.println("Value is : " +a);
		System.out.println(super.name);	
	}
}
