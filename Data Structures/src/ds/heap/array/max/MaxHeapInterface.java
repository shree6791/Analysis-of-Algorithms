package ds.heap.array.max;

public interface MaxHeapInterface {

	final int CAPACITY = 5;

	public int size();

	public boolean isEmpty();

	public void insertElement(int element);

	public int peek() throws MaxHeapEmptyException;

	public void removeMaximum() throws MaxHeapEmptyException;

}
