package ds.sort;

import java.util.Scanner;

public class InsertionSort {

	static int swap = 0;
	static int comp = 0;

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n");
	}

	public void insertionSort(int arr[]) {

		int len = arr.length;

		for (int j = 1; j < len; j++) {

			int key = arr[j];
			int i = j - 1;

			if (arr[i] <= key)
				comp++;

			//System.out.println("inner " + i + " outer " + j + " comparisons " + comp);

			while ((i > -1) && (arr[i] > key)) {
				arr[i + 1] = arr[i];
				swap++;
				comp++;
				i--;
			}

			//System.out.println("comparisons " + comp + "\n");

			arr[i + 1] = key;
			printArray(arr);

		}
	}

	public static void main(String[] args) {

		InsertionSort is = new InsertionSort();

		System.out.println("Enter Array Size");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("Enter Array Elements");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println("Insertion Sort\n");
		is.insertionSort(arr);

		System.out.println("Total Number of Swaps : " + swap);
		System.out.println("Total Number of Comparisons : " + comp);
		sc.close();

	}

}
