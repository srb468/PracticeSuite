package Shapes;

public class Bubble {

	public static void main(String args[]) {

		int temp = 0;
		int arr[] = { 5, 1, 4, 2, 8 };
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}