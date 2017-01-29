package ds.queue.linkedList;

public class Node {

	Node next;
	Object element;

	public Node(Node next, Object element) {
		super();
		this.next = next;
		this.element = element;
	}

	public Node() {
		this(null,null);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

}
