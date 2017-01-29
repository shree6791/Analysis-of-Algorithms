package ds.heap.array.max;

public class MaxHeapMain {

	public static void main(String[] args) throws MaxHeapEmptyException {

		MaxHeap hs = new MaxHeap();

		hs.insertElement(5);
		hs.insertElement(2);
		hs.insertElement(1);
		hs.insertElement(-1);
		hs.insertElement(-3);
		hs.insertElement(6);

		System.out.println("Heap Size " + hs.size());
		System.out.println("Maximum Value of Heap : " + hs.peek());

		hs.removeMaximum();
		hs.removeMaximum();
		hs.removeMaximum();
		hs.removeMaximum();
		hs.removeMaximum();

		System.out.println("Heap Size " + hs.size());
		System.out.println("Maximum Value of Heap : " + hs.peek());

	}

}
