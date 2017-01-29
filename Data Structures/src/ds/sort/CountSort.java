package ds.sort;

public class CountSort {

	void countingSort(int[] A, int n, int u) {

		int counts[] = new int[u];

		for (int i = 0; i < u; i++)
			counts[i] = 0;

		// Find Repetition Count of Each Element in Array
		for (int i = 0; i < n; i++)
			counts[A[i]] = counts[A[i]] + 1;

		for (int i = 0; i < u; i++)
			System.out.print(counts[i] + " ");

		System.out.println();

		int index = 0;

		// Display An Array Representing The Numbers Repeated Count Times
		for (int i = 0; i < u; i++) {
			for (int j = 0; j < counts[i]; j++) {
				A[index] = i;
				index = index + 1;
			}
		}

		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");

	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 3, 2, 4, 3, 0, 1, 0, 4 };

		// Display Input Array
		for (int i = 0; i < 10; i++)
			System.out.print(arr[i] + " ");

		System.out.println();

		CountSort cs = new CountSort();
		cs.countingSort(arr, 10, 5);

	}

}
