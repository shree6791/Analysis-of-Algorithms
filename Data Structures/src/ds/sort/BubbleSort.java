package ds.sort;

import java.util.Scanner;

public class BubbleSort {

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void selectionSort(int[] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++)
				if (arr[j + 1] < arr[j])
					swapElements(arr, j, j + 1);

			printArray(arr);
		}

	}

	public void swapElements(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String[] args) {

		BubbleSort bs = new BubbleSort();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("Bubble Sort");
		bs.selectionSort(arr);
		sc.close();

	}

}
