package ds.heap.array.min;

public interface MinHeapInterface {

	final int CAPACITY = 5;

	public int size();

	public boolean isEmpty();

	public void insertElement(int element);

	public int peek() throws MinHeapEmptyException;

	public void removeMinimum() throws MinHeapEmptyException;

}
