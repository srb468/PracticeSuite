package Reflection;

public class BaseClass {

	BaseClass() {
		System.out.println("In constructor");

	}

	public int sum(int a, int b) {
		//System.out.println(a+b);
		return a+b;

	}

	public int substract(int a,int b) {
		return a-b;
	}
	
	public void print(int a,int b) {
		System.out.println(a+" and"+b);
	}
}
