package ds.queue.doublyLinkedList;

public class QueueDoubleLinkedList implements QueueInterface {

	private int size;
	private Node head, tail;

	public QueueDoubleLinkedList() {
		size = 0;
		head = new Node();
		tail = new Node();
		head.setNextNode(tail);
		tail.setPreviousNode(head);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (head.getNextNode() == null)
			return true;
		return false;
	}

	@Override
	public void enqueue(Object element) {

		Node nextNode = head.getNextNode();
		Node currentNode = new Node(element, head, nextNode);
		nextNode.setPreviousNode(currentNode);
		head.setNextNode(currentNode);
		size++;

	}

	@Override
	public Object front() throws QueueEmptyException {
		if (size == 0)
			throw new QueueEmptyException("Queue is Empty");
		else
			return head.getNextNode().getElement();
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		
		if (size == 0)
			throw new QueueEmptyException("Queue is Empty");

		Node lastNode = tail.getPreviousNode();
		Object element = lastNode.getElement();

		Node beforeLastNode = lastNode.getPreviousNode();
		tail.setPreviousNode(beforeLastNode);
		beforeLastNode.setNextNode(tail);
		size--;
		return element;

	}

}
