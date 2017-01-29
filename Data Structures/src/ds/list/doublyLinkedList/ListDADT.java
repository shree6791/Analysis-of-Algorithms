package ds.list.doublyLinkedList;

public class ListDADT implements ListInterface {

	int size;
	Node head, tail;

	public ListDADT() {
		size = 0;
		head = new Node();
		tail = new Node();
		head.setNext(tail);
		tail.setPrevious(head);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object rear() {
		return tail.getPrevious().getElement();
	}

	@Override
	public Object front() {
		return head.getNext().getElement();
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void insertAtLast(Object element) {

		Node lastNode = tail.previous;
		Node currentNode = new Node(element, tail, lastNode);
		lastNode.setNext(currentNode);
		tail.setPrevious(currentNode);
		size++;
	}

	@Override
	public void insertAtStart(Object element) {

		Node firstNode = head.getNext();
		Node currentNode = new Node(element, firstNode, head);
		firstNode.setPrevious(currentNode);
		head.setNext(currentNode);
		size++;

	}

	@Override
	public void removeAtLast() throws ListEmptyException {

		if (isEmpty())
			throw new ListEmptyException("List is Empty");

		Node lastNode = tail.previous;
		Node beforeLastNode = lastNode.getPrevious();
		tail.setPrevious(beforeLastNode);
		beforeLastNode.setNext(tail);
		size--;

	}

	@Override
	public void removeAtStart() throws ListEmptyException {

		if (isEmpty())
			throw new ListEmptyException("List is Empty");

		Node firstNode = head.getNext();
		Node afterFirstNode = firstNode.getNext();
		afterFirstNode.setPrevious(head);
		head.setNext(afterFirstNode);
		size--;

	}

	@Override
	public void insertAtPosition(int position, Object element) {

		int count = 0;
		Node previousNode = head;

		while (count < position) {
			count++;
			previousNode = previousNode.next;
		}

		Node nextNode = previousNode.next;
		Node currentNode = new Node(element, nextNode, previousNode);
		nextNode.setPrevious(currentNode);
		previousNode.setNext(currentNode);
		size++;
	}

	@Override
	public void removeAtPosition(int position) throws ListEmptyException {

		if (isEmpty())
			throw new ListEmptyException("List is Empty");

		int count = 0;
		Node previousNode = head;

		while (count < position) {
			count++;
			previousNode = previousNode.next;
		}

		Node currentNode = previousNode.next;
		previousNode.setNext(currentNode.next);
		currentNode.getNext().setPrevious(previousNode);

		size--;

	}

}
