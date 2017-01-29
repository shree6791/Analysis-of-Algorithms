package ds.queue.linkedList;

public interface QueueInterface {

	public int size();

	public boolean isEmpty();

	public void enqueue(Object element);

	public Object front() throws QueueEmptyException;

	public Object dequeue() throws QueueEmptyException;

}
