package ds.queue.linkedList;

public class QueueLinkedList implements QueueInterface {

	int size;
	Node head, tail;

	public QueueLinkedList() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public Object front() throws QueueEmptyException {

		if (size == 0)
			throw new QueueEmptyException("Queue is Empty");
		else
			return head.getElement();
	}

	@Override
	public Object dequeue() throws QueueEmptyException {

		Object element;

		if (size == 0)
			throw new QueueEmptyException("Queue is Empty");

		element = head.getElement();
		head = head.getNext();
		size--;

		if (size == 0)
			tail = null;

		return element;
	}

	@Override
	public void enqueue(Object element) {

		Node node = new Node();
		node.setElement(element);
		node.setNext(null);

		if (size == 0)
			head = node;
		else
			tail.setNext(node);

		tail = node;
		size++;
	}

	public void insertAtPosition(int position, Object element) {

		Node node = new Node();
		node.element = element;
		node.next = null;

		size++;
		int count = 0;
		Node current = head;

		while (count < position - 1) {
			count++;
			current = current.next;
		}

		if (position == 0) {
			node.next = head;
			head = node;
			tail = node;
		}

		else if (count == size - 1) {
			current = node;
			tail = node;
		}

		else {

			Node after = current.next;
			current.next = node;
			node.next = after;
		}

	}
	
	public Node reverseQueueOrder(Node node) {
		
		if (node == null || node.next == null)
			return node;
		else{
			
			Node reverse = reverseQueueOrder(node.next);
			node.next.next = node;
			node.next = null;			
			head = reverse;
			
			return reverse;			
		}
		
	}
	
	public void printQueueElements(Node node) {

		if (node == null)
			;
		else{
			System.out.print(node.element + " ");
			printQueueElements(node.next);
		}

	}

}
