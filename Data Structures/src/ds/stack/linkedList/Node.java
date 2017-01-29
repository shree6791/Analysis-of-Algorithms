package ds.stack.linkedList;

public class Node {

	private Node previous;
	private Object element;

	public Node() {
		super();
	}

	public Node(Node previous, Object element) {
		super();
		this.previous = previous;
		this.element = element;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	
	
}
