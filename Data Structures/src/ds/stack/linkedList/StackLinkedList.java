package ds.stack.linkedList;

public class StackLinkedList implements StackInterface {

	private int size;
	private Node head;

	public StackLinkedList() {
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

	@Override
	public void push(Object element) {

		Node node = new Node();
		node.setElement(element);
		node.setPrevious(head);
		head = node;
		size++;

	}

	@Override
	public Object top() throws StackEmptyException {

		if (isEmpty() == true)
			throw new StackEmptyException("Stack is Empty");
		else
			return head.getElement();

	}

	@Override
	public Object pop() throws StackEmptyException {

		if (isEmpty() == true)
			throw new StackEmptyException("Stack is Empty");

		Object element = head.getElement();
		head = head.getPrevious();
		size--;

		return element;

	}

}
