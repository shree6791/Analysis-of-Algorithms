package ds.queue.array;

public class QueueArray implements QueueInterface {

	private Object[] queueArray;
	private final int MAX_SIZE = 5;
	private int size, headIndex, tailIndex;

	public QueueArray() {
		size = -1;
		tailIndex = 0;
		headIndex = 0;
		queueArray = new Object[MAX_SIZE];
	}

	@Override
	public int size() {
		size = (MAX_SIZE - headIndex + tailIndex) % MAX_SIZE;
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (headIndex == tailIndex)
			return true;
		return false;
	}

	@Override
	public Object front() throws QueueEmptyException {

		if (isEmpty() == true)
			throw new QueueEmptyException("Queue is Empty");
		else
			return queueArray[headIndex];
	}

	@Override
	public Object dequeue() throws QueueEmptyException {

		if (isEmpty() == true)
			throw new QueueEmptyException("Queue is Empty");

		Object element = queueArray[headIndex];

		queueArray[headIndex] = null;
		headIndex = (headIndex + 1) % MAX_SIZE;

		return element;

	}

	@Override
	public void enqueue(Object element) throws QueueFullException {

		if (size() == MAX_SIZE - 1)
			throw new QueueFullException("Queue is Full");

		queueArray[tailIndex] = element;
		tailIndex = (tailIndex + 1) % MAX_SIZE;

	}

}
