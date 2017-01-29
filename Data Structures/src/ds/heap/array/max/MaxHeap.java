package ds.heap.array.max;

import java.util.Arrays;

public class MaxHeap implements MaxHeapInterface {

	int size;
	Integer[] arr;

	public MaxHeap() {
		size = 0;
		arr = new Integer[CAPACITY];
	}

	@Override
	public int size() {
		return size;
	}

	public void upHeap() {

		int currentIndex = size;

		while (parentExists(currentIndex)) {

			int parentIndex = currentIndex / 2;
			int parentValue = arr[parentIndex];
			int currentValue = arr[currentIndex];

			if (parentValue > currentValue)
				break;
			else
				swapElements(parentIndex, currentIndex);

			currentIndex = parentIndex;

		}
	}

	public void downHeap() {

		int parentIndex = 0;

		while (leftChildExists(parentIndex)) {

			int currentIndex = leftChildIndex(parentIndex);

			if (rightChildExists(parentIndex))
				if (arr[currentIndex] < (arr[rightChildIndex(parentIndex)]))
					currentIndex = rightChildIndex(parentIndex);

			if (arr[parentIndex] < arr[currentIndex])
				swapElements(parentIndex, currentIndex);
			else
				break;

			parentIndex = currentIndex;
		}

	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void insertElement(int element) {

		if (size > arr.length - 1)
			resize();

		arr[size] = element;
		upHeap();
		size++;
	}

	@Override
	public int peek() throws MaxHeapEmptyException {

		if (isEmpty())
			throw new MaxHeapEmptyException("Heap is Empty");

		return arr[0];

	}

	@Override
	public void removeMaximum() throws MaxHeapEmptyException {

		if (isEmpty())
			throw new MaxHeapEmptyException("Heap is Empty");

		size--;
		int minVal = arr[0];
		arr[0] = arr[size];
		arr[size] = null;

		downHeap();
		System.out.println(minVal);

	}

	public void resize() {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}

	public int leftChildIndex(int i) {
		return 2 * i + 1;
	}

	public int rightChildIndex(int i) {
		return 2 * i;
	}

	public boolean parentExists(int i) {
		return i > 0;
	}

	public boolean leftChildExists(int i) {
		return leftChildIndex(i) < size;
	}

	public boolean rightChildExists(int i) {
		return rightChildIndex(i) < size;
	}

	public void swapElements(int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
