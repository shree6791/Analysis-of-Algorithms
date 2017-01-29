package ds.list.linkedList;

public class Node {

	Node next;
	Object element;
	
	public Node() {
		super();
	}

	public Node(Object element) {
		super();
		this.element = element;
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
