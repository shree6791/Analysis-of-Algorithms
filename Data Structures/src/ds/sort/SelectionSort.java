package ds.sort;

import java.util.Scanner;

public class SelectionSort {

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void selectionSort(int[] arr) {

		int minIndex;
		int len = arr.length;
		
		for (int i = 0; i < len; i++) {

			minIndex = i;

			for (int j = i + 1; j < len; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;
			
			swapElements(arr, i, minIndex);
			printArray(arr);
			
		}
	}

	public void swapElements(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String[] args) {

		SelectionSort ss = new SelectionSort();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("Selection Sort");
		ss.selectionSort(arr);
		sc.close();

	}

}
