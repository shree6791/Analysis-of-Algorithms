package ds.stack.doublyLinkedList;

import ds.queue.doublyLinkedList.Node;

public class StackDoubleLinkedList implements StackInterface {

	private int size;
	private Node head, tail;

	public StackDoubleLinkedList() {
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
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void push(Object element) {

		Node nextNode = head.getNextNode();
		Node currentNode = new Node(element, head, nextNode);
		nextNode.setPreviousNode(currentNode);
		head.setNextNode(currentNode);
		size++;

	}

	@Override
	public Object top() throws StackEmptyException {

		if (size == 0)
			throw new StackEmptyException("Stack is Empty");
		return head.getNextNode().getElement();

	}

	@Override
	public Object pop() throws StackEmptyException {

		if (size == 0)
			throw new StackEmptyException("Srack is Empty");

		Node firstNode = head.getNextNode();
		Object element = firstNode.getElement();

		Node secondNode = firstNode.getNextNode();
		head.setNextNode(secondNode);
		secondNode.setPreviousNode(head);

		size--;
		return element;

	}

}
