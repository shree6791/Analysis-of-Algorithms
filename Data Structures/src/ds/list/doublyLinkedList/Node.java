package ds.list.doublyLinkedList;

public class Node {

	Object element;
	Node next, previous;

	public Node() {
		super();
	}
	
	public Node(Object element) {
		super();
		this.element = element;
	}
	
	public Node(Object element, Node next, Node previous) {
		super();
		this.element = element;
		this.next = next;
		this.previous = previous;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}
