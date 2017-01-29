package ds.heap.array.min;

public class MinHeapMain {

	public static void main(String[] args) throws MinHeapEmptyException {

		MinHeap hs = new MinHeap();

		hs.insertElement(5);
		hs.insertElement(2);
		hs.insertElement(1);
		hs.insertElement(-1);
		hs.insertElement(-3);
		hs.insertElement(6);

		System.out.println("Heap Size " + hs.size());
		System.out.println("Minimum Value of Heap : " + hs.peek());

		hs.removeMinimum();
		hs.removeMinimum();
		hs.removeMinimum();
		hs.removeMinimum();
		hs.removeMinimum();
		hs.removeMinimum();

		System.out.println("Minimum Value of Heap : " + hs.peek());

	}

}
