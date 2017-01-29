package ds.stack.doublyLinkedList;

public class Node {

	Object element;
	Node nextNode, previousNode;

	public Node() {
		super();
	}

	public Node(Object element, Node nextNode, Node previousNode) {
		super();
		this.element = element;
		this.nextNode = nextNode;
		this.previousNode = previousNode;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}



}
