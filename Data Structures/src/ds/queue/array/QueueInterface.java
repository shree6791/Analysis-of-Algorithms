package ds.queue.array;

public interface QueueInterface {

	public int size();

	public boolean isEmpty();

	public Object front() throws QueueEmptyException;

	public Object dequeue() throws QueueEmptyException;

	public void enqueue(Object element) throws QueueFullException;
}
