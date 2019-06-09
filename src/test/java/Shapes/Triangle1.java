package Shapes;

import org.testng.annotations.Test;

public class Triangle1 {
	// @Test(priority = 1)
	public void shape1() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {

				System.out.print("*");
			}
			System.out.println();
		}
	}

	// @Test(priority = 2)
	public void shape2() {

		for (int i = 5; i > 0; i--) {
			for (int j = 5; j >= i; j--) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}

	// @Test(priority = 3)
	public void shape3() {

		for (int i = 5; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	// @Test(priority = 4)
	public void shape4() {
		int len = 5;

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len - i; j++) {
				System.out.print(" ");
			}
			for (int a = 1; a <= i; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	// @Test(priority = 5)
	public void shape5() {
		int len = 5;

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len - i; j++) {
				System.out.print(" ");
			}
			for (int a = 1; a <= 2 * i - 1; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	// @Test(priority = 6)
	public void shape6() {
		int len = 4;

		for (int i = 1; i <= len; i++) {

			for (int j = 1; j <= len; j++) {
				if (i == 1 || i == len || j == 1 || j == len) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}

	// @Test(priority = 7)
	public void diamond() {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");

			}

			System.out.println();
		}

	}

	@Test(priority = 8)
	public void invertedTriangle() {

		String a = "Here is java";
		String rev="";
		int len = a.toCharArray().length;
		System.out.println(len);
		for (int i = len; i >= 1; i--) {
			if(rev.charAt(i)==' ') {
				System.out.println("sfdasd");
			System.out.println(rev.charAt(i));
		}
		}
	}
}
