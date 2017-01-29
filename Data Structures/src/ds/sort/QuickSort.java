package ds.sort;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	static int swap, comp = 0;

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void swapElements(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public void pivotSelection(int[] arr, int start, int end) {

		Random r = new Random();
		int randomIndex = end;//r.nextInt(end - start + 1) + start;
		swapElements(arr, randomIndex, end);

	}

	public Pair partition(int[] arr, int start, int end) {

		pivotSelection(arr, start, end);

		int pivot = arr[end];
		Pair pair = new Pair();
		int pivotIndex = start;

		comp += end - start;

		for (int i = start; i < end; i++)
			if (arr[i] <= pivot) {
				swapElements(arr, i, pivotIndex);
				pivotIndex++;
				swap++;
			}

		swapElements(arr, pivotIndex, end);
		pair.key = pivotIndex;
		pair.array = arr;
		swap++;

		return pair;

	}

	public int[] quickSort(int[] arr, int start, int end) {

		if (start < end) {

			Pair pair = new Pair();
			pair = partition(arr, start, end);
			printArray(arr);

			arr = pair.array;
			int pivotIndex = pair.key;
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);

		}
		return arr;

	}

	public static void main(String[] args) {

		QuickSort qs = new QuickSort();

		System.out.println("Enter Array Size");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("Enter Array Elements");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		// Quick Sort
		qs.quickSort(arr, 0, arr.length - 1);
		System.out.println("Total number of swaps : " + swap);
		System.out.println("Total number of comparisons : " + comp);
		sc.close();

	}

}
