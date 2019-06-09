package Shapes;

public class BubbleSortDesc {

	public static void main(String args[]) {
		
		int temp = 0;
		int arr[] = { 5, 55, 32, 11, 3, 4 };
		for (int i = 0; i < arr.length-1; i++) {

			for (int j = 0; j < arr.length-1; j++) {
				if (arr[i] > arr[j]) {
					temp=arr[j];
					arr[j]=arr[i];
					arr[i] =temp;
				}

			}

		}
		for(int n=0;n<arr.length;n++) {
			System.out.print(arr[n]+" ");
		}
	}

}
