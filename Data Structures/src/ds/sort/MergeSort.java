package ds.sort;

import java.util.Scanner;

public class MergeSort {

	public void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public void mergeSort(int[] arr) {

		int len = arr.length;

		if (len > 1) {

			int mid = len / 2;
			int[] left = new int[mid];
			int[] right = new int[len - mid];

			left = divideArray(arr, 0, mid);
			right = divideArray(arr, mid, len);

			mergeSort(left);
			mergeSort(right);
			mergeArray(arr, left, right);

		}
	}

	public int[] divideArray(int[] arr, int start, int end) {

		int len = arr.length;
		int mid = arr.length / 2;
		int[] smallArray = new int[end - start];

		if (start == 0) {
			for (int i = 0; i < mid; i++)
				smallArray[i] = arr[i];
		} else {
			for (int i = 0; i < len - mid; i++)
				smallArray[i] = arr[mid + i];
		}

		return smallArray;

	}

	public void mergeArray(int[] arr, int[] left, int[] right) {

		int i = 0;
		int j = 0;
		int leftLen = left.length;
		int rightLen = right.length;

		while (i < leftLen && j < rightLen) {

			if (left[i] < right[j]) {
				arr[i + j] = left[i];
				i++;
			} else {
				arr[i + j] = right[j];
				j++;
			}

		}

		for (; i < leftLen; i++)
			arr[i + j] = left[i];
		for (; j < rightLen; j++)
			arr[i + j] = right[j];

	}

	public static void main(String[] args) {

		MergeSort ms = new MergeSort();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		// Merge Sort
		System.out.println("Merge Sort");
		ms.mergeSort(arr);
		ms.printArray(arr);
		sc.close();

	}

}
