package com.practiceSuite;

import java.util.ArrayList;

public class ArrayMovement {
	int temp;

	public static void main(String args[]) {
		int temp;
		int a[] = { 5, 0, 8, 3, 1 };
		int b = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == 0) {
				temp = a[i + 1];
				a[i + 1] = a[i];
				a[i] = temp;
			}
		}
	}
}
